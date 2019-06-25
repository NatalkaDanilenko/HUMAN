package services;

import com.sun.istack.internal.Nullable;
import student.Group;
import student.Student;

public class FindStudentInGroup {
    private Group group = new Group();

    public FindStudentInGroup(Group group) {
        this.group = group;
    }

    public FindStudentInGroup() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Nullable
    public Student findStudent(String name) {
        Student [] arrStudent = group.getGroup();
        if (name == null || name.equals("") == true){
            throw new IllegalArgumentException("Student can not be null!");
        }

        for (Student student : arrStudent) {
            if (student == null){
                continue;
            }
            if (student.getName().equals(name) == true) {
                return student;
            }
        }
        return null;
    }

}
