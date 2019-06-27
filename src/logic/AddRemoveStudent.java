package logic;

import exception.AddStudentException;
import exception.RemoveStudentException;
import student.Gender;
import student.Group;
import student.Student;

public class AddRemoveStudent {
    private Group group = new Group();

    public AddRemoveStudent() {
    }

    public AddRemoveStudent(Group group) {
        this.group = group;
    }

    public void addRemoveStudent() {
        try {
            group.addStudent(new Student("Rodion Gazmanow",
                    21, Gender.MAN, "KPI named by I. Sikorsky",
                    "FICT", 2, "FC22"));
        } catch (
                AddStudentException e) {
            System.out.println(e);
        }
        System.out.println(group.toString());

        try {
            group.removeStudent(group.getGroup()[4]);
        } catch (
                RemoveStudentException e) {
            System.out.println(e);
        }

        System.out.println(group.toString());
    }
}
