package org.example.queries;

import org.example.wrappers.*;

import java.util.ArrayList;
import java.util.List;

public class PopulateDB {
    public List<Workers> getWorkers(){
        List<Workers> workers = new ArrayList<>();

        workers.add(new Workers("Oleg","1982-12-23", Level.Trainee,500));
        workers.add(new Workers("Victoria","1995-06-18",Level.Senior,6000));
        workers.add(new Workers("Nataly","1962-12-01",Level.Middle,2500));
        workers.add(new Workers("Denys","1991-06-09",Level.Trainee,600));
        workers.add(new Workers("Dmytro","2001-08-28",Level.Junior,1500));
        workers.add(new Workers("Darya","2000-08-19",Level.Middle,3600));
        workers.add(new Workers("Stepan","1995-09-04",Level.Senior,5000));
        workers.add(new Workers("Anna","2000-01-06",Level.Senior,5700));
        workers.add(new Workers("Ruslan","1974-05-27",Level.Middle,3000));
        workers.add(new Workers("Olena","1971-04-10",Level.Trainee,750));

        return workers;
    }

    public List<Clients> getClients(){
        List<Clients> clients = new ArrayList<>();

        clients.add(new Clients("Julio"));
        clients.add(new Clients("James"));
        clients.add(new Clients("Anastasia"));
        clients.add(new Clients("Frederico"));
        clients.add(new Clients("Orlando"));

        return clients;
    }

    public List<Project> getProject(){
        List<Project> projects = new ArrayList<>();

        projects.add(new Project(3, "2019-08-14", "2021-11-02"));
        projects.add(new Project(1, "2020-12-23", "2023-12-23"));
        projects.add(new Project(2, "2021-10-16", "2023-01-20"));
        projects.add(new Project(1, "2022-06-08", "2024-08-21"));
        projects.add(new Project(5, "2018-03-09", "2027-09-16"));
        projects.add(new Project(2, "2020-07-24", "2021-12-29"));
        projects.add(new Project(4, "2019-01-19", "2026-10-03"));
        projects.add(new Project(1, "2023-02-01", "2023-10-07"));
        projects.add(new Project(3, "2018-07-08", "2025-09-23"));
        projects.add(new Project(2, "2021-11-30", "2023-05-17"));

        return projects;
    }

    public List<ProjectWorker> getProjectWorker(){
        List<ProjectWorker> projectWorkers = new ArrayList<>();

        projectWorkers.add(new ProjectWorker(1,5));
        projectWorkers.add(new ProjectWorker(1,9));
        projectWorkers.add(new ProjectWorker(2,6));
        projectWorkers.add(new ProjectWorker(3,10));
        projectWorkers.add(new ProjectWorker(1,8));
        projectWorkers.add(new ProjectWorker(4,8));
        projectWorkers.add(new ProjectWorker(4,3));
        projectWorkers.add(new ProjectWorker(5,3));
        projectWorkers.add(new ProjectWorker(5,4));
        projectWorkers.add(new ProjectWorker(6,5));
        projectWorkers.add(new ProjectWorker(6,6));
        projectWorkers.add(new ProjectWorker(6,7));
        projectWorkers.add(new ProjectWorker(7,8));
        projectWorkers.add(new ProjectWorker(7,7));
        projectWorkers.add(new ProjectWorker(7,9));
        projectWorkers.add(new ProjectWorker(8,10));
        projectWorkers.add(new ProjectWorker(8,1));
        projectWorkers.add(new ProjectWorker(8,3));
        projectWorkers.add(new ProjectWorker(8,4));
        projectWorkers.add(new ProjectWorker(9,2));
        projectWorkers.add(new ProjectWorker(9,8));
        projectWorkers.add(new ProjectWorker(10,6));
        projectWorkers.add(new ProjectWorker(10,3));
        projectWorkers.add(new ProjectWorker(10,5));

        return projectWorkers;
    }
}
