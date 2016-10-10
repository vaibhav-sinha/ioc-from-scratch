package com.freshpipe.ioc.v11;

/**
 * Created by vaibhav on 10/10/16.
 */
public class SystemPrintStream implements PrintStream {

    @Override
    public void println(String s) {
        System.out.println(s);
    }
}
