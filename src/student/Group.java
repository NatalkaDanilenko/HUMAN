package student;

import exception.AddStudentException;
import exception.RemoveStudentException;

import java.util.Arrays;

public class Group {
    private Student[] group = new Student[10];

    public Group() {
    }

    public Group(Student[] group) {
        this.group = group;
    }

    public Student[] getGroup() {
        return group;
    }

    public void setGroup(Student[] group) {
        this.group = group;
    }

    public void addStudent(Student st) throws AddStudentException {
        boolean flag = true;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == null) {
                group[i] = st;
                flag = false;
                break;
            }
        }
        if (flag) {
            throw new AddStudentException("The list of group is already full. You can not add new student.");
        }
    }

    public void removeStudent(Student st) throws RemoveStudentException {
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

    public int findStudentByName(Student st) throws RemoveStudentException {
        if (group != null) {
            for (int i = 0; i < group.length; i++) {
                if (group[i].getName().equals(st.getName())) {
                    return i;
                }
            }
        } else {
            throw new RemoveStudentException("The list of group is empty. You can not find / remove student.");
        }
        return -1;
    }

    public void sortGroup() {
        Student st;
        boolean flag;
        for (;;) {
            flag = true;
            for (int i = 0; i < group.length - 1; i++) {
                if ((group[i] == null) ||
                        ((group[i] != null) && (group[i + 1] != null))
                        && (group[i].getName().compareTo(group[i + 1].getName()) > 0)) {
                    st = group[i];
                    group[i] = group[i + 1];
                    group[i + 1] = st;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" + Arrays.toString(group) + super.toString() +
                '}';
    }
}
