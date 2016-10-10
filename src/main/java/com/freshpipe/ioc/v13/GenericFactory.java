package com.freshpipe.ioc.v13;

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

    private static Class config;

    public static void setConfig(Class configClass) {
        config = configClass;
    }

    public static <T> InstanceRecord<T> create(Class<T> tClass, String name) throws Exception {
        T objectFromConfig = getObjectFromConfig(tClass, name);
        if(objectFromConfig != null) {
            return new InstanceRecord<T>(objectFromConfig, name);
        }
        //Scan the entire project
        Reflections reflections = new Reflections("com.freshpipe.ioc.v13");
        Set<Class<? extends T>> subTypes = reflections.getSubTypesOf(tClass);
        Class<? extends T> classToCreate = getOneValidSubtype(subTypes, tClass);
        T object = classToCreate.newInstance();
        for (Field field : classToCreate.getDeclaredFields()) {
            if(field.isAnnotationPresent(Autowired.class)) {
                String qualifier = field.getAnnotation(Autowired.class).qualifier();
                if(qualifier.equals("")) {
                    qualifier = field.getType().getName();
                }
                field.setAccessible(true);
                field.set(object, Registry.get(field.getType(), qualifier));
            }
        }
        for(Method method: classToCreate.getMethods()) {
            if(method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(object);
            }
        }
        return new InstanceRecord<T>(object, name);

    }

    private static <T> Class<? extends T> getOneValidSubtype(Set<Class<? extends T>> subTypes, Class tClass) throws Exception {
        if(!tClass.isInterface() && !Modifier.isAbstract(tClass.getModifiers())) {
            return tClass;
        }
        Class concreteClassToUse = (Class) config.getMethod("getConcreteClassToUse", Class.class).invoke(config, tClass);
        if(concreteClassToUse != null) {
            return concreteClassToUse;
        }
        for (Class subType : subTypes) {
            if(!subType.isInterface() && !Modifier.isAbstract(subType.getModifiers())) {
                return subType;
            }
        }
        throw new InstantiationError("No valid subtype found for " + tClass);
    }

    private static <T> T getObjectFromConfig(Class<T> c, String name) throws Exception {
        for(Method method: config.getMethods()) {
            if(method.isAnnotationPresent(Bean.class) && method.getAnnotation(Bean.class).name().equals(name) && method.getReturnType().isAssignableFrom(c)) {
                return (T) method.invoke(config);
            }
        }
        return null;
    }

}
