package student;

public class NullCheck {
    public static final int NOT_NULL = 7;

    public static int ckeckObject(Object a, Object b){
        if (a != null && b == null){
            return 1;
        }

        if (a == null && b != null){
            return -1;
        }
        if (a == null && b == null){
            return 0;
        }
        return NOT_NULL;
    }
}
