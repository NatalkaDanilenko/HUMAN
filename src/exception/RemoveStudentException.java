package exception;

public class RemoveStudentException extends Exception {
    public RemoveStudentException(String s) {
        System.out.println(s);
    }
}
