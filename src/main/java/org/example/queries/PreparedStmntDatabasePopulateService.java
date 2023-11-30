package org.example.queries;

import org.example.config.Database;
import org.example.wrappers.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PreparedStmntDatabasePopulateService {
    Connection connection;
    public static final String PREPARED_STATEMENT_INSERT_WORKER  = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?);";

    public static final String PREPARED_STATEMENT_INSERT_CLIENT = "INSERT INTO client (name) VALUES (?);";

    public static final String PREPARED_STATEMENT_INSERT_PROJECT = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?);";

    public static final String PREPARED_STATEMENT_INSERT_PROJECT_WORKER = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?);";

    private PreparedStatement transactionalPrepareStatementWorker;
    private PreparedStatement transactionalPrepareStatementClient;
    private PreparedStatement transactionalPrepareStatementProject;
    private PreparedStatement transactionalPrepareStatementProjectWorker;

    public PreparedStmntDatabasePopulateService() {
        this.connection = Database.get_instance().getConnection();
        try {
            this.transactionalPrepareStatementWorker = connection.prepareStatement(PREPARED_STATEMENT_INSERT_WORKER);
            this.transactionalPrepareStatementClient = connection.prepareStatement(PREPARED_STATEMENT_INSERT_CLIENT);
            this.transactionalPrepareStatementProject = connection.prepareStatement(PREPARED_STATEMENT_INSERT_PROJECT);
            this.transactionalPrepareStatementProjectWorker = connection.prepareStatement(PREPARED_STATEMENT_INSERT_PROJECT_WORKER);
        } catch(SQLException e) {
            System.out.println("Can not create Statements. Reason:" + e.getMessage());
        }
    }

    public void dbPopulate(List<Workers> workers, List<Clients> clients, List<Project> projects, List<ProjectWorker> projectWorkers){
        try {

            for(Workers worker : workers) {
                transactionalPrepareStatementWorker.setString(1, worker.getName());
                transactionalPrepareStatementWorker.setDate(2, java.sql.Date.valueOf(worker.getBirthday()));
                transactionalPrepareStatementWorker.setObject(3, worker.getLevel(), java.sql.Types.OTHER);
                transactionalPrepareStatementWorker.setInt(4, worker.getSalary());
                transactionalPrepareStatementWorker.addBatch();
            }

            for(Clients client : clients) {
                transactionalPrepareStatementClient.setString(1, client.getName());
                transactionalPrepareStatementClient.addBatch();
            }

            for(Project project : projects) {
                transactionalPrepareStatementProject.setInt(1, project.getClientId());
                transactionalPrepareStatementProject.setDate(2, java.sql.Date.valueOf(project.getStartDate()));
                transactionalPrepareStatementProject.setDate(3, java.sql.Date.valueOf(project.getEndDate()));
                transactionalPrepareStatementProject.addBatch();
            }

            for(ProjectWorker projectWorker : projectWorkers) {
                transactionalPrepareStatementProjectWorker.setInt(1, projectWorker.getProjectId());
                transactionalPrepareStatementProjectWorker.setInt(2, projectWorker.getWorkerId());
                transactionalPrepareStatementProjectWorker.addBatch();
            }
            try {
                transactionalPrepareStatementWorker.executeBatch();
                transactionalPrepareStatementClient.executeBatch();
                transactionalPrepareStatementProject.executeBatch();
                transactionalPrepareStatementProjectWorker.executeBatch();

            } catch(SQLException e) {
                System.out.println("TRANSACTIONAL FAIL. Rollback changes. Reason: " + e.getMessage());
                connection.rollback();
                throw e;
            }

        } catch(SQLException e) {
            System.out.println("Can not create Statements. Reason:" + e.getMessage());
        }
    }
}
