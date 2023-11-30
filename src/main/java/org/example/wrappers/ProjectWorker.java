package org.example.wrappers;
public class ProjectWorker {
    private final int projectId;
    private final int workerId;
    public ProjectWorker(int projectId, int workerId){
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getWorkerId() {
        return workerId;
    }
}
