import exception.AddStudentException;
import exception.RemoveStudentException;
import student.Gender;
import student.Group;
import student.Student;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Student [] students = new Student[10];
        students[0] = new Student("Vasia Pupkin",
                19, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22");
        students[1] = new Student("Masha Repkina",
                20, Gender.WOMAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22");
        students[2] = new Student("Kola Moroz",
                21, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22");
        students[3] = new Student("Garik Bircha",
                19, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22");
        students[4] = new Student("Oleg Vinnyk",
                20, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22");
        Group group = new Group(221, students);
        System.out.println(group.toString());
        try {
            group.addStudent(new Student("Rodion Gazmanow",
                    21, Gender.MAN, "KPI named by I. Sikorsky",
                    "FICT", 2, "FC22"));
        } catch (AddStudentException e) {
            System.out.println(e);
        }
        System.out.println(group.toString());

        try {
            group.removeStudent(students[4]);
        } catch (RemoveStudentException e) {
            System.out.println(e);
        }

        System.out.println(group.toString());



        System.out.println(group.findStudent("Rodion Gazmanow"));

        try {
            group.addInteractiveSt();
        } catch (AddStudentException e) {
            e.printStackTrace();
        }

        group.setGroup(group.sortGroup());
        System.out.println("Sorted by name: " + group.toString());

        System.out.println(Arrays.toString(group.getToArmyNow()));

        group.sortByGender();
        //System.out.println("Sorted by gender: " + group.toString());
        group.writeGroupInFile();
    }
}
