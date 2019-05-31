package student;

public class Student extends People {
    private String university;
    private String faculty;
    private int year;
    private String groupName;
    private int studNumber;
    private int performance;
    private boolean hungry;
    private boolean studentHostel;

    public Student(String name, int age, Gender gender, String university, String faculty, int year, String groupName, int studNumber, int performance, boolean hungry, boolean studentHostel) {
        super(name, age, gender);
        this.university = university;
        this.faculty = faculty;
        this.year = year;
        this.groupName = groupName;
        this.studNumber = studNumber;
        this.performance = performance;
        this.hungry = hungry;
        this.studentHostel = studentHostel;
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

    public int getStudNumber() {
        return studNumber;
    }

    public void setStudNumber(int studNumber) {
        this.studNumber = studNumber;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public boolean isStudentHostel() {
        return studentHostel;
    }

    public void setStudentHostel(boolean studentHostel) {
        this.studentHostel = studentHostel;
    }

    @Override
    public String toString() {
        return "student.Student{" +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                ", groupName='" + groupName + '\'' +
                ", studNumber=" + studNumber +
                ", performance=" + performance +
                ", hungry=" + hungry +
                ", studentHostel=" + studentHostel +
                ", " + super.toString() +
                '}';
    }
}
