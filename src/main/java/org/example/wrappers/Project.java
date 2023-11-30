package org.example.wrappers;

public class Project {
    private final int clientId;
    private final String startDate;
    private final String endDate;
    public Project(int clientId, String startDate, String endDate){
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getClientId() {
        return clientId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
