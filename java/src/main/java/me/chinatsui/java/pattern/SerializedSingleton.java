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

class SerializedSingletonTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton instance1 = SerializedSingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializedSingleton.ser"));
        oos.writeObject(instance1);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializedSingleton.ser"));
        SerializedSingleton instance2 = (SerializedSingleton) ois.readObject();
        ois.close();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}