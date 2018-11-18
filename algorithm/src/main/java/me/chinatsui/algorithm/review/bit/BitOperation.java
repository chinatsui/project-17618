package me.chinatsui.algorithm.review.bit;

public enum BitOperation {

    INSTANCE;

    public static void main(String[] args) {
        int a = 10; // ... 0000 1010
        int b = 42; // ... 0010 1010

        // &
        // 0 & 0 = 0
        // 0 & 1 = 0
        // 1 & 0 = 0
        // 1 & 1 = 1
        // a & b = ... 0000 1010 (10)
        System.out.println(a & b);

        // |
        // 0 | 0 = 0
        // 0 | 1 = 1
        // 1 | 0 = 1
        // 1 | 1 = 1
        // a | b = ... 0010 1010 (42)
        System.out.println(a | b);

        // ^
        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        // 1 ^ 0 = 1
        // 1 ^ 1 = 0
        // a ^ b = ... 0010 0000 (32)
        System.out.println(a ^ b);

        // ~
        // 取非操作，所有位 0变1，1变0，然后在此基础上值减一
        System.out.println(~a);

        // <<
        // a << 1 = ... 0001 0100 (20)
        // a << 2 = ... 0010 1000 (40)
        System.out.println(a << 1);
        System.out.println(a << 2);

        // >>  最高位符号位不变
        // a >> 1 = ... 0000 0101 (5)
        // a >> 2 = ... 0000 0010 (2)
        System.out.println(a >> 1);
        System.out.println(a >> 2);

        // >>> 最高位符号位永远置0
        // -10 >>> 1
        // 1000 ... ... 1010 >>> 0100 ... ... 0101
        System.out.println(-10 >>> 1);
        System.out.println(5 >>> 1);
    }

}
