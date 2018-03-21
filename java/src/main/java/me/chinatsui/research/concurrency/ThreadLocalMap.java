package me.chinatsui.research.concurrency;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalMap {

    private static ThreadLocal<Map> holder = ThreadLocal.withInitial(()-> new HashMap());

    public static Map getMap(){
        return holder.get();
    }

}
