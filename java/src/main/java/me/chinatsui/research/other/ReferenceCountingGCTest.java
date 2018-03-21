package me.chinatsui.research.other;

public class ReferenceCountingGCTest {

    private Object instance;

    private byte[] buffer = new byte[2 * 1024 * 1024];

    public static void main(String[] args) {

        ReferenceCountingGCTest rcgcA = new ReferenceCountingGCTest();
        ReferenceCountingGCTest rcgcB = new ReferenceCountingGCTest();

        rcgcA.instance = rcgcB;
        rcgcB.instance = rcgcA;

        rcgcA = null;
        rcgcB = null;

        System.gc();
    }

}
