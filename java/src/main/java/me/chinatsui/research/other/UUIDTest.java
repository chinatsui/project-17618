package me.chinatsui.research.other;

import java.util.UUID;

/**
 * Created by chinatsui on 01/02/2018.
 */
public class UUIDTest {

    public static void main(String[] args) {
        UUID u1 = UUID.fromString("ec0e974f-a9aa-456b-875e-3514ba403d08");
        UUID u2 = UUID.fromString("ec0e974f-a9aa-456b-875e-3514ba403d08");
        String x = new String("ec0e974f-a9aa-456b-875e-3514ba403d08");
        String y = "ec0e974f-a9aa-456b-875e-3514ba403d08";
        System.out.println("ec0e974f-a9aa-456b-875e-3514ba403d08" == y);
    }

}
