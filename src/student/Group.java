package student;

import com.sun.istack.internal.Nullable;
import exception.AddStudentException;
import exception.RemoveStudentException;
import javax.swing.JOptionPane;
import java.util.Arrays;

import static student.Gender.MAN;
import static student.Gender.WOMAN;

public class Group implements Voenka {
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
            if (student == null){
                continue;
            }
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

    public void addInteractiveSt() throws AddStudentException {
        Student st = new Student();
        try {
            st.setName(String.valueOf(JOptionPane.showInputDialog("Input name of student:")));
            st.setAge(Integer.valueOf(JOptionPane.showInputDialog("Input age:")));
            st.setGender(Gender.valueOf((JOptionPane.showInputDialog("Input gender (man / woman):")).toUpperCase()));
            st.setYear(Integer.valueOf(JOptionPane.showInputDialog("Input year:")));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error number format");
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Cancel");
        }

        if (st == null){
            throw new IllegalArgumentException("You try to add null value. Please, check input params and try again later.");
        }

        checkParam(st);

        addStudent(st);
    }

    private void checkParam(Student st) {
        String groupN = "";
        String facult = "";
        String un = "";
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null) {
                groupN = group[i].getGroupName();
                facult = group[i].getFaculty();
                un = group[i].getUniversity();
                break;
            }
        }
        st.setGroupName(groupN);
        st.setFaculty(facult);
        st.setUniversity(un);
    }

    @Override
    public Student [] getToArmyNow(){
        int n = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null
                    && group[i].getAge() > 18
                    && group[i].getGender() == MAN){
                n++;
            }
        }
        Student[] st = new Student[n];
        Group gr = new Group(st);
        for (int i = 0; i < group.length; i++) {
            if (group[i] != null
                    && group[i].getAge() > 18
                    && group[i].getGender() == MAN){
                try {
                    gr.addStudent(group[i]);
                } catch (AddStudentException e) {
                    e.printStackTrace();
                }
            }
        }

        return gr.getStudent();
    }

    private Student[] getStudent() {
        return group;
    }

    public Student [] sortByGender(){
        if (group == null){
            return null;
        }
        int n = 0;
        while (n < group.length) {
            for (int i = 0; i < group.length - 1; i++) {
                if (group[i] != null && group[i + 1] != null) {
                    Gender a = group[i].getGender();
                    Gender b = group[i + 1].getGender();
                    if (a == MAN && b == WOMAN){
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

}
