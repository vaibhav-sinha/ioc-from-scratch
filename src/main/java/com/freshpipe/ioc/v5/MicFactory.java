package com.freshpipe.ioc.v5;

/**
 * Created by vaibhav on 10/10/16.
 */
public class MicFactory {

    public static Mic create() {
        return new Mic(System.out);
    }
}
