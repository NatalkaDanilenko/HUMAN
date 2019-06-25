package services;

import exception.AddStudentException;
import student.Gender;
import student.Group;
import student.Student;

import javax.swing.*;

public class AddInteractiveStudent {
    private Group group = new Group();

    public AddInteractiveStudent(Group group) {
        this.group = group;
    }

    public AddInteractiveStudent() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

        group.addStudent(st);
    }

    private void checkParam(Student st) {
        String groupN = "";
        String facult = "";
        String un = "";
        Student [] arrStudent = group.getGroup();
        for (int i = 0; i < arrStudent.length; i++) {
            if (arrStudent[i] != null) {
                groupN = arrStudent[i].getGroupName();
                facult = arrStudent[i].getFaculty();
                un = arrStudent[i].getUniversity();
                break;
            }
        }
        st.setGroupName(groupN);
        st.setFaculty(facult);
        st.setUniversity(un);
    }
}
