package services;

import com.sun.istack.internal.Nullable;
import student.Gender;
import student.Group;
import student.Student;

import static student.Gender.MAN;
import static student.Gender.WOMAN;

public class SortStudentInGroup {
    private Group group = new Group();

    public SortStudentInGroup(Group group) {
        this.group = group;
    }

    public SortStudentInGroup() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Nullable
    public Student[] sortGroup() {
        Student [] arrStudent = group.getGroup();
        if (arrStudent == null){
            return null;
        }
        int n = 0;
        while (n < arrStudent.length) {
            for (int i = 0; i < arrStudent.length - 1; i++) {
                if (arrStudent[i] != null && arrStudent[i + 1] != null) {
                    int a = arrStudent[i].getName().split(" ")[0].compareTo(arrStudent[i + 1].getName().split(" ")[0]);
                    if (a < 0) {
                        Student st = arrStudent[i];
                        arrStudent[i] = arrStudent[i + 1];
                        arrStudent[i + 1] = st;
                    }
                } else if (arrStudent[i] == null && arrStudent[i + 1] != null) {
                    Student st = arrStudent[i];
                    arrStudent[i] = arrStudent[i + 1];
                    arrStudent[i + 1] = st;
                }
            }
            n++;
        }
        return arrStudent;
    }

    @Nullable
    public Student [] sortByGender(){
        Student [] arrStudent = group.getGroup();
        if (arrStudent == null){
            return null;
        }
        int n = 0;
        while (n < arrStudent.length) {
            for (int i = 0; i < arrStudent.length - 1; i++) {
                if (arrStudent[i] != null && arrStudent[i + 1] != null) {
                    Gender a = arrStudent[i].getGender();
                    Gender b = arrStudent[i + 1].getGender();
                    if (a == MAN && b == WOMAN){
                        Student st = arrStudent[i];
                        arrStudent[i] = arrStudent[i + 1];
                        arrStudent[i + 1] = st;
                    }
                } else if (arrStudent[i] == null && arrStudent[i + 1] != null) {
                    Student st = arrStudent[i];
                    arrStudent[i] = arrStudent[i + 1];
                    arrStudent[i + 1] = st;
                }
            }
            n++;
        }
        return arrStudent;
    }

}
