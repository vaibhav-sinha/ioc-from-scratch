package com.freshpipe.ioc.v14;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhav on 10/10/16.
 */
public class TestConfig {

    public static List<Class> getPrototypeScopedClasses() {
        List<Class> prototypeClasses = new ArrayList<>();
        prototypeClasses.add(NewsReader.class);
        return prototypeClasses;
    }

    public static Class getConcreteClassToUse(Class c) {
//        if(c == Clock.class) {
//            return UTCSystemClock.class;
//        }
        return null;
    }

    public static Glasses glasses() {
        Glasses glasses = new Glasses();
        glasses.setMagnify(false);
        return glasses;
    }

    public static Clock clock() {
        UTCSystemClock clock = new UTCSystemClock();
        clock.setDifference(2);
        return clock;
    }
}
