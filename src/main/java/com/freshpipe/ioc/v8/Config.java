package com.freshpipe.ioc.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhav on 10/10/16.
 */
public class Config {

    public static List<Class> getPrototypeScopedClasses() {
        List<Class> prototypeClasses = new ArrayList<>();
        prototypeClasses.add(NewsReader.class);
        return prototypeClasses;
    }

    public static Class getConcreteClassToUse(Class c) {
        if(c == Clock.class) {
            return UTCSystemClock.class;
        }
        return null;
    }
}
