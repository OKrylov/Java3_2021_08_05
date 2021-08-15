package jdbc;

import java.util.Objects;

public class Student {

    private final long id;
    private final String name;
    private final String groupName;
    private final int score;

    public Student(long id, String name, String groupName, int score) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && score == student.score && Objects.equals(name, student.name) && Objects.equals(groupName, student.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, groupName, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupName='" + groupName + '\'' +
                ", score=" + score +
                '}';
    }
}
