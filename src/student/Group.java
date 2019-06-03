package student;

import com.sun.istack.internal.Nullable;
import exception.AddStudentException;
import exception.RemoveStudentException;
//import javax.swing.JOptionPane;
import java.util.Arrays;

//import static student.Gender.MAN;

public class Group implements Voenka {
    private int number = 0;
    private Student[] group = new Student[10];

    public Group() {
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
        if (st == null){
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
    public Student findStudent(String name) {
        if (name == null || name.equals("") == true){
            throw new IllegalArgumentException("Student can not be null!");
        }
        for (Student student : group) {
            if (student.getName().equals(name) == true) {
                return student;
            }
        }
        return null;
    }

    public Student [] sortGroup() {
        if (group == null){
            return null;
        }
        int n = 0;
        while (n < group.length) {
            for (int i = 0; i < group.length - 1; i++) {
                if (group[i] != null && group[i + 1] != null) {
                    int a = group[i].getName().split(" ")[0].compareTo(group[i + 1].getName().split(" ")[0]);
                    if (a < 0) {
                        Student st = group[i];
                        group[i] = group[i + 1];
                        group[i + 1] = st;
                    }
                } else if (group[i] == null && group[i + 1] != null) {
                    Student st = group[i];
                    group[i] = group[i + 1];
                    group[i + 1] = st;
                }
            }
            n++;
        }
        return group;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" + number + "\nStudents:\n" +  Arrays.toString(group) + super.toString() +
                '}';
    }

    /*public void addInteractiveSt() throws AddStudentException {
        Student st = new Student();
            st.setName(String.valueOf(JOptionPane.showInputDialog("Input name of student:")));
            st.setFaculty(String.valueOf(JOptionPane.showInputDialog("Input faculty of student:")));
            st.setGroupName(String.valueOf(JOptionPane.showInputDialog("Input group of student:")));
            st.setYear(Integer.valueOf(JOptionPane.showInputDialog("Input information of student:")));
        addStudent(st);
    }*/

    @Override
    public Student [] getToArmyNow(){
        String st [] = new String[1];
        /*for (int i = 0; i < group.length; i++) {
            if (group[i] != null
                    && group[i].getAge() > 18
                    && group[i].getGender() == MAN){
                resize(st, group[i].getName());
            }
        }*/
        return new Student[0];
    }

}
