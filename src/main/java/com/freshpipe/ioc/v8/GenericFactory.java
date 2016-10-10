package com.freshpipe.ioc.v8;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by vaibhav on 10/10/16.
 */
@SuppressWarnings("unchecked")
public class GenericFactory {

    public static <T> T create(Class<T> tClass) throws Exception {
        //Scan the entire project
        Reflections reflections = new Reflections("com.freshpipe.ioc.v8");
        Set<Class<? extends T>> subTypes = reflections.getSubTypesOf(tClass);
        Class<? extends T> classToCreate = getOneValidSubtype(subTypes, tClass);
        //Always use the first constructor
        Constructor constructor = classToCreate.getConstructors()[0];
        Class[] parameterTypes = constructor.getParameterTypes();
        if(parameterTypes == null || parameterTypes.length == 0) {
            return classToCreate.newInstance();
        }
        else {
            List<Object> parameters = new ArrayList<>();
            for(Class c: parameterTypes) {
                parameters.add(Registry.get(c));
            }
            return (T) constructor.newInstance(parameters.toArray());
        }
    }

    private static <T> Class<? extends T> getOneValidSubtype(Set<Class<? extends T>> subTypes, Class tClass) {
        if(!tClass.isInterface() && !Modifier.isAbstract(tClass.getModifiers())) {
            return tClass;
        }
        if(Config.getConcreteClassToUse(tClass) != null) {
            return Config.getConcreteClassToUse(tClass);
        }
        for (Class subType : subTypes) {
            if(!subType.isInterface() && !Modifier.isAbstract(subType.getModifiers())) {
                return subType;
            }
        }
        throw new InstantiationError("No valid subtype found for " + tClass);
    }

}
