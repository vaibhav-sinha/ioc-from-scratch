package com.freshpipe.ioc.v5;

import java.io.PrintStream;

/**
 * Created by vaibhav on 09/10/16.
 */
public class Mic {

    private PrintStream printStream;

    public Mic(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void say(String message) {
        printStream.println(message);
    }
}
