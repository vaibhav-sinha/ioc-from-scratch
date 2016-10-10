package com.freshpipe.ioc.v12;


import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vaibhav on 10/10/16.
 */
@SuppressWarnings("unchecked")
public class Registry {

    private static MultiValuedMap<Class, Object> cache = new ArrayListValuedHashMap<>();
    private static Class config;

    public static void setConfig(Class configClass) {
        config = configClass;
        GenericFactory.setConfig(configClass);
    }

    public static <T> T get(Class<T> tClass) throws Exception {
        if(isClassSingleton(tClass) && cache.get(tClass) != null && !cache.get(tClass).isEmpty()) {
            return (T) cache.get(tClass).iterator().next();
        }
        else {
            T object = GenericFactory.create(tClass);
            cache.put(tClass, object);
            return object;
        }
    }

    private static boolean isClassSingleton(Class c) throws Exception {
        List<Class> prototypeClasses = (ArrayList<Class>) config.getMethod("getPrototypeScopedClasses").invoke(config);
        return !prototypeClasses.contains(c);
    }
}
