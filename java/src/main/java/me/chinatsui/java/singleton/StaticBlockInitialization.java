package me.chinatsui.java.singleton;

/*
 * Static block initialization implementation is similar to eager initialization,
 * except that instance of class is created in the static block that provides option for exception handling.
 */
public class StaticBlockInitialization {

    private static final StaticBlockInitialization instance;

    static {
        try {
            instance = new StaticBlockInitialization();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private StaticBlockInitialization() {
    }

    public static StaticBlockInitialization getInstance() {
        return instance;
    }
}
