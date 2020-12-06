package by.aginskiy.autopark.util;

public class IdGenerator {

    private static int id;

    public static int getId() {
        return id++;
    }
}
