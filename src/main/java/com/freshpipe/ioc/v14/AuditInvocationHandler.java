package com.freshpipe.ioc.v14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by vaibhav on 11/10/16.
 */
public class AuditInvocationHandler implements InvocationHandler {

    private Object original;

    public AuditInvocationHandler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method invocation started at " + new Date());
        Object toReturn = method.invoke(original, args);
        System.out.println("Method invocation ended at " + new Date());
        return toReturn;
    }
}
