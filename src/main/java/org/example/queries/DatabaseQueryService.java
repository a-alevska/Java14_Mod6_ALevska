package org.example.queries;

import org.example.config.Database;
import org.example.wrappers.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    Connection connection;

    public DatabaseQueryService(){
        connection = Database.get_instance().getConnection();
    }

    private String selectQueryReader(String filename){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            StringBuilder sqlQuery = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlQuery.append(line).append(" ");
            }
            return sqlQuery.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQueryReader("sql/find_max_projects_client.sql"));
            while (rs.next()){
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(rs.getString("client_name"));
                client.setProjectCount(rs.getInt("project_count"));
                maxProjectCountClients.add(client);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxProjectCountClients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> maxSalaryWorker = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQueryReader("sql/find_max_salary_worker.sql"));
            while (rs.next()){
                MaxSalaryWorker worker = new MaxSalaryWorker();
                worker.setName(rs.getString("name"));
                worker.setSalary(rs.getInt("salary"));
                maxSalaryWorker.add(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxSalaryWorker;
    }

    public List<LongestProject> findLongestProject(){
        List<LongestProject> longestProject = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQueryReader("sql/find_longest_project.sql"));
            while (rs.next()){
                LongestProject project = new LongestProject();
                project.setId(rs.getInt("project_id"));
                project.setDuration(rs.getInt("duration_months"));
                longestProject.add(project);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return longestProject;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQueryReader("sql/find_youngest_eldest_workers.sql"));
            while (rs.next()){
                YoungestEldestWorkers workers = new YoungestEldestWorkers();
                workers.setType(rs.getString("type"));
                workers.setName(rs.getString("name"));
                workers.setBirthday(rs.getDate("birthday"));
                youngestEldestWorkers.add(workers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public List<ProjectPrices> findProjectPrices(){
        List<ProjectPrices> projectPrices = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQueryReader("sql/print_project_prices.sql"));
            while (rs.next()){
                ProjectPrices projectPrice = new ProjectPrices();
                projectPrice.setId(rs.getString("project"));
                projectPrice.setPrice(rs.getInt("price"));
                projectPrices.add(projectPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projectPrices;
    }
}

