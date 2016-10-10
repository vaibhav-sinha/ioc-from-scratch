package com.freshpipe.ioc.v13;


import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by vaibhav on 10/10/16.
 */
@SuppressWarnings("unchecked")
public class Registry {

    private static MultiValuedMap<Class, InstanceRecord> cache = new ArrayListValuedHashMap<>();
    private static Class config;

    public static void setConfig(Class configClass) {
        config = configClass;
        GenericFactory.setConfig(configClass);
    }

    public static <T> T get(Class<T> tClass) throws Exception {
        return get(tClass, null);
    }

    public static <T> T get(Class<T> tClass, String name) throws Exception {
        String nameToUse = name;
        if(nameToUse == null) {
            nameToUse = tClass.getName();
        }
        Collection<InstanceRecord> fromCache = cache.get(tClass);
        if(isClassSingleton(tClass)) {
            if(fromCache != null) {
                InstanceRecord<T> lastSavedWhichMatches = null;
                int matchCount = 0;
                while (fromCache.iterator().hasNext()) {
                    InstanceRecord<T> currentRecord = fromCache.iterator().next();
                    if(currentRecord.isEqual(name)) {
                        lastSavedWhichMatches = currentRecord;
                        matchCount = matchCount + 1;
                    }
                }
                if(matchCount == 0) {
                    InstanceRecord<T> instanceRecord = GenericFactory.create(tClass, nameToUse);
                    cache.put(tClass, instanceRecord);
                    return instanceRecord.getObject();
                }
                else if(matchCount == 1) {
                    return lastSavedWhichMatches.getObject();
                }
                else {
                    throw new Exception("Found multiple beans qualifying for type " + tClass);
                }
            }
            else {
                InstanceRecord<T> instanceRecord = GenericFactory.create(tClass, nameToUse);
                cache.put(tClass, instanceRecord);
                return instanceRecord.getObject();
            }
        }
        else {
            InstanceRecord<T> instanceRecord = GenericFactory.create(tClass, nameToUse);
            cache.put(tClass, instanceRecord);
            return instanceRecord.getObject();
        }
    }

    private static boolean isClassSingleton(Class c) throws Exception {
        List<Class> prototypeClasses = (ArrayList<Class>) config.getMethod("getPrototypeScopedClasses").invoke(config);
        return !prototypeClasses.contains(c);
    }

}
