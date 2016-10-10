package com.freshpipe.ioc.v10;


import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

/**
 * Created by vaibhav on 10/10/16.
 */
@SuppressWarnings("unchecked")
public class Registry {

    private static MultiValuedMap<Class, Object> cache = new ArrayListValuedHashMap<>();

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

    private static boolean isClassSingleton(Class c) {
        return !Config.getPrototypeScopedClasses().contains(c);
    }
}
