package services;

import student.Group;
import student.Student;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteGroup {
    private Group group = new Group();

    public WriteGroup(Group group) {
        this.group = group;
    }

    public WriteGroup() {
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void writeGroupInFile(){
        File file = new File("Group.csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getReport(group.getGroup(), file);
    }

    public void getReport(Student[] group, File file){
        try (PrintWriter pw = new PrintWriter(file)){
            for (int i = 0; i < group.length; i++) {
                if(group[i]!=null) {

                    pw.println(group[i]);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
