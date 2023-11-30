package org.example;

import org.example.queries.DatabaseQueryService;
import org.example.queries.PopulateDB;
import org.example.queries.PreparedStmntDatabaseInitService;
import org.example.queries.PreparedStmntDatabasePopulateService;
import org.example.wrappers.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PreparedStmntDatabaseInitService initService = new PreparedStmntDatabaseInitService();
        PreparedStmntDatabasePopulateService populateService = new PreparedStmntDatabasePopulateService();

        initService.dbInit();

        List<Workers> workers = new PopulateDB().getWorkers();
        List<Clients> clients = new PopulateDB().getClients();
        List<Project> projects = new PopulateDB().getProject();
        List<ProjectWorker> projectWorkers = new PopulateDB().getProjectWorker();

        populateService.dbPopulate(workers, clients, projects, projectWorkers);

        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
        List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject();
        List<ProjectPrices> projectPrices = new DatabaseQueryService().findProjectPrices();
        List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestEldestWorkers();


        System.out.println(maxProjectCountClients.toString()+"\n"+maxSalaryWorkers.toString()+"\n"+
                longestProjects.toString()+"\n"+"Project prices are\n"+projectPrices.toString()+
                "\n"+"Youngest and Eldest Workers are\n"+youngestEldestWorkers.toString());
    }
}