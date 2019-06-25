package student;

import com.sun.istack.internal.Nullable;
import exception.AddStudentException;
import exception.RemoveStudentException;

import java.io.Serializable;
import java.util.Arrays;

import static student.Gender.MAN;

public class Group implements Voenka, Serializable {
    private static final long serialVersionUID = 1L;
    private int number = 0;
    private Student[] group = new Student[10];

    public Group() {
    }

    public Group(Student[] group) {
        this.group = group;
    }

    public Group(int number, Student[] group) {
        this.number = number;
        this.group = group;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student[] getGroup() {
        return group;
    }

    public void setGroup(Student[] group) {
        this.group = group;
    }

    private Student[] getStudent() {
        return group;
    }

    public void addStudent(Student st) throws AddStudentException {
        for (int i = 0; i < group.length; i++) {
            if (group[i] == null) {
                group[i] = st;
                return;
            }
        }
        throw new AddStudentException("The list of group is already full. You can not add new student.");
    }

    public void removeStudent(Student st) throws RemoveStudentException {
        if (st == null) {
            throw new IllegalArgumentException("Student can not be null!");
        }
        if (group != null) {
            for (int i = 0; i < group.length; i++) {
                if (group[i].getName().equals(st.getName())) {
                    group[i] = null;
                    return;
                }
            }
        } else {
            throw new RemoveStudentException("The list of group is empty. You can not find / remove student.");
        }
    }


    @Nullable
    @Override
    public Student[] getToArmyNow() {
        int n = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null
                    && group[i].getAge() > 18
                    && group[i].getGender() == MAN) {
                n++;
            }
        }
        Student[] st = new Student[n];
        Group gr = new Group(st);
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null
                    && group[i].getAge() > 18
                    && group[i].getGender() == MAN) {
                try {
                    gr.addStudent(group[i]);
                } catch (AddStudentException e) {
                    e.printStackTrace();
                }
            }
        }

        return gr.getStudent();
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" + number + "\nStudents:\n" + Arrays.toString(group) + super.toString() +
                '}';
    }


}
