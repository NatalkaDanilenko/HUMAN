package exception;

public class AddStudentException extends Exception {
    private String str;

    public AddStudentException() {
    }

    public AddStudentException(String str) {
        this.str = str;
    }

    @Override
    public String getMessage() {
        return str;
    }
}
