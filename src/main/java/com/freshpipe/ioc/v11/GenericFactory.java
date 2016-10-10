package com.freshpipe.ioc.v11;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

/**
 * Created by vaibhav on 10/10/16.
 */
@SuppressWarnings("unchecked")
public class GenericFactory {

    public static <T> T create(Class<T> tClass) throws Exception {
        T objectFromConfig = getObjectFromConfig(tClass);
        if(objectFromConfig != null) {
            return objectFromConfig;
        }
        //Scan the entire project
        Reflections reflections = new Reflections("com.freshpipe.ioc.v11");
        Set<Class<? extends T>> subTypes = reflections.getSubTypesOf(tClass);
        Class<? extends T> classToCreate = getOneValidSubtype(subTypes, tClass);
        T object = classToCreate.newInstance();
        for (Field field : classToCreate.getDeclaredFields()) {
            if(field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                field.set(object, Registry.get(field.getType()));
            }
        }
        for(Method method: classToCreate.getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(object);
            }
        }
        return object;

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

    private static <T> T getObjectFromConfig(Class<T> c) throws Exception {
        for(Method method: Config.class.getMethods()) {
            if(method.getReturnType().isAssignableFrom(c)) {
                return (T) method.invoke(Config.class);
            }
        }
        return null;
    }

}
