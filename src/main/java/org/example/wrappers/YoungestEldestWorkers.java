package org.example.wrappers;
import java.util.Date;
import java.util.Objects;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private Date birthday;

    public YoungestEldestWorkers(){
        type = "";
        name = "";
        birthday = new Date();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}'+ "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YoungestEldestWorkers workers = (YoungestEldestWorkers) o;
        return Objects.equals(type, workers.type) && Objects.equals(name, workers.name) && Objects.equals(birthday, workers.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, birthday);
    }
}
