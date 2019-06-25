import exception.AddStudentException;
import logic.AddRemoveStudent;
import logic.CreateGroup;
import logic.SaveGetGroupFromFile;
import services.*;
import student.Group;

import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        CreateGroup create = new CreateGroup();
        Group group = create.createGroup();
        System.out.println(group.toString());
        SaveGetGroupFromFile saveGetGroupFromFile = new SaveGetGroupFromFile(group);
        saveGetGroupFromFile.SaveIntoFile();
        saveGetGroupFromFile.GetFromFile();

        AddRemoveStudent addAndRemove = new AddRemoveStudent(group);
        addAndRemove.AddRemoveStudent();

        FindStudentInGroup findSt = new FindStudentInGroup(group);
        System.out.println(findSt.findStudent("Rodion Gazmanow"));

        try {
            new AddInteractiveStudent(group).addInteractiveSt();
        } catch (AddStudentException e) {
            e.printStackTrace();
        }

        SortStudentInGroup sortSt = new SortStudentInGroup(group);

        group.setGroup(sortSt.sortGroup());
        System.out.println("Sorted by name: " + group.toString());

        System.out.println(Arrays.toString(group.getToArmyNow()));

        sortSt.sortByGender();
        //System.out.println("Sorted by gender: " + group.toString());

        new WriteGroup(group).writeGroupInFile();
        File file1 = new File("/Users/nataliadanilenko/Documents/GIT/HUMAN/Group.csv");

        try {
            System.out.println("Group from file: " + new CreateGroup().createGroupFromFile(file1).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
