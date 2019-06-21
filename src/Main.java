import exception.AddStudentException;
import student.Gender;
import student.Group;
import student.Student;

import java.io.*;
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

        try(ObjectOutputStream OOS=new ObjectOutputStream(new FileOutputStream("fil"))){
            OOS.writeObject(group);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Group newGroup = null;
        try (ObjectInputStream OIS=new ObjectInputStream(new FileInputStream("fil"))){
            newGroup = (Group)OIS.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Вывод данных считанного объекта");

        System.out.println(newGroup.toString());


        /*
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
*/
        /*group.sortByGender();
        //System.out.println("Sorted by gender: " + group.toString());
        group.writeGroupInFile();
        File file1 = new File("/Users/nataliadanilenko/Documents/GIT/HUMAN/Group.csv");

        try {
            System.out.println("Group from file: " + createGroup(file1).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    /*private static Group createGroup(File file1) throws IOException {
        Group myGroup = new Group();
        String[] str1 = readFile(file1).split("\n");

        System.out.println(Arrays.toString(str1));
        for (String s : str1) {
            Student st = new Student();
            String [] info = s.split(", ");
            for (int i = 0; i < info.length; i++) {
                String [] currInfo = info[i].split("=");
                if(currInfo[0].equals("name")){
                    st.setName(currInfo[1]);
                }
                if(currInfo[0].equals("age")){
                    st.setAge(Integer.valueOf(currInfo[1]));
                }
                if(currInfo[0].equals("gender")){
                    st.setGender(Gender.valueOf(currInfo[1]));
                }
                if(currInfo[0].equals("university")){
                    st.setUniversity(currInfo[1]);
                }
                if(currInfo[0].equals("faculty")){
                    st.setFaculty(currInfo[1]);
                }
                if(currInfo[0].equals("year")){
                    st.setYear(Integer.valueOf(currInfo[1]));
                }
                if(currInfo[0].equals("groupName")){
                    st.setGroupName(currInfo[1]);
                }
                if(currInfo[0].equals("null")){
                    continue;
                }
            }
            try {
                myGroup.addStudent(st);
            } catch (AddStudentException e) {
                e.printStackTrace();
            }
        }

        return myGroup;
    }*/

    /*public static String readFile(File file) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(file));
        String str = "";
        String out = "";
        for (; (str = f.readLine()) != null; ) {
            out = out + str+"\n";
        }
        return out;
    }*/
}
