package logic;

import student.Group;

import java.io.*;

public class SaveGetGroupFromFile {
    private Group group = new Group();

    public SaveGetGroupFromFile() {
    }

    public SaveGetGroupFromFile(Group group) {
        this.group = group;
    }

    public void saveIntoFile() {
        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil"))) {
            OOS.writeObject(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFromFile() {
        Group newGroup = null;
        try (
                ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
            newGroup = (Group) OIS.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Вывод данных считанного объекта");

        System.out.println(newGroup.toString());
    }
}
