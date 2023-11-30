package org.example.wrappers;

public class Workers {
    private final String name;
    private final String birthday;
    private final Level level;
    private final int salary;
    public Workers(String name, String birthday, Level level, int salary){
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public Level getLevel() {
        return level;
    }

    public int getSalary() {
        return salary;
    }
}
