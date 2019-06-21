package student;

import java.io.Serializable;

public class Student extends People implements Serializable {
    private static final long serialVersionUID = 1L;
    private String university;
    private String faculty;
    private int year;
    private String groupName;

    public Student(String name, int age, Gender gender, String university, String faculty, int year, String groupName) {
        super(name, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.year = year;
        this.groupName = groupName;
    }

    public Student() {
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                ", groupName='" + groupName + '\'';
    }
}
