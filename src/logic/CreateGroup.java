package logic;

import exception.AddStudentException;
import student.Gender;
import student.Group;
import student.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public  class CreateGroup {
    public CreateGroup() {
    }

    public Group createGroup(){
        Student[] students = new Student[10];
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
        return new Group(221, students);
    }

    public Group createGroupFromFile(File file1) throws IOException {
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
    }

    public static String readFile(File file) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(file));
        String str = "";
        String out = "";
        for (; (str = f.readLine()) != null; ) {
            out = out + str+"\n";
        }
        return out;
    }

}
