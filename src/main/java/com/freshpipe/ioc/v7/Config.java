package com.freshpipe.ioc.v7;

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
}
