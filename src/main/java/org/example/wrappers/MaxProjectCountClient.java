package org.example.wrappers;

import java.util.Objects;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;
    public MaxProjectCountClient(){
        name = "";
        projectCount = 0;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Max Project Count Client is{" +
                "name='" + name + '\'' +
                "projectCount=" + projectCount +
                '}'+ "\n" ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxProjectCountClient that = (MaxProjectCountClient) o;
        return projectCount == that.projectCount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectCount);
    }
}
