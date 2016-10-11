package com.freshpipe.ioc.v14;

/**
 * Created by vaibhav on 10/10/16.
 */
public class InstanceRecord<T> {

    private T object;
    private String name;

    public InstanceRecord(T object, String name) {
        this.object = object;
        this.name = name;
    }

    public boolean isEqual(String name) {
        if(this.name == null || name == null || this.name.equals("")) {
            return true;
        }
        else {
            return name.equals(this.name);
        }
    }

    public T getObject() {
        return object;
    }
}
