package com.freshpipe.ioc.v6;

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
