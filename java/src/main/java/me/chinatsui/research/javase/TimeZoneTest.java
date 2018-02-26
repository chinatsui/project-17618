package me.chinatsui.research.javase;

import java.util.TimeZone;

/**
 * Created by chinatsui on 24/01/2018.
 */
public class TimeZoneTest {

    public static void main(String[] args) {
        System.out.println(TimeZone.getTimeZone("Europe/Copenhagen").getID());
    }

}
