package me.chinatsui.java.pattern;

import java.io.*;

public class SerializedSingleton implements Serializable {

    private static final long serialVersionUID = 1L;

    private SerializedSingleton() {
    }

    private static class SingletonHelper {
        private static final SerializedSingleton instance = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHelper.instance;
    }

    /*
     * Used to avoid deserialization creates a new instance of the class.
     */
    protected Object readResolve() {
        return getInstance();
    }
}
