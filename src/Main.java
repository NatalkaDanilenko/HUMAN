import exception.AddStudentException;
import exception.RemoveStudentException;
import student.Gender;
import student.Group;
import student.Student;

public class Main {
    public static void main(String[] args) {
        Student [] students = new Student[10];
        students[0] = new Student("Vasia Pupkin",
                19, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22", 2203,
                4, true,false);
        students[1] = new Student("Masha Repkina",
                20, Gender.WOMAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22", 2206,
                2, false,true);
        students[2] = new Student("Kola Moroz",
                21, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22", 2209,
                4, true,true);
        students[3] = new Student("Garik Bircha",
                19, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22", 2204,
                3, true,false);
        students[4] = new Student("Oleg Vinnyk",
                20, Gender.MAN, "KPI named by I. Sikorsky",
                "FICT", 2, "FC22", 2207,
                3, true,true);
        Group group = new Group(students);
        System.out.println(group.toString());
        try {
            group.addStudent(new Student("Rodion Gazmanow",
                    21, Gender.MAN, "KPI named by I. Sikorsky",
                    "FICT", 2, "FC22", 2208,
                    3, true,true));
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

        group.sortGroup();

        System.out.println("Sorted by name: " + group.toString());
    }
}
