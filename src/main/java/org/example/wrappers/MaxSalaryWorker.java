package org.example.wrappers;

import java.util.Objects;

public class MaxSalaryWorker {
    private String name;
    private int salary;

    public MaxSalaryWorker(){
        name = "";
        salary = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Max Salary Worker is{" +
                "name='" + name + '\'' +
                "salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxSalaryWorker that = (MaxSalaryWorker) o;
        return salary == that.salary && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }
}
