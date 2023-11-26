package org.example;

import java.util.Objects;

public class LongestProject {
    private int id;
    private int duration;

    public LongestProject(){
        id = 0;
        duration = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString() {
        return "Longest Project is {" +
                "id=" + id +
                "duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongestProject project = (LongestProject) o;
        return id == project.id && duration == project.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration);
    }
}
