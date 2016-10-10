package com.freshpipe.ioc.v11;

/**
 * Created by vaibhav on 09/10/16.
 */
public class Mic {

    @Autowired
    private PrintStream printStream;

    public void say(String message) {
        printStream.println(message);
    }

    public void check() {
        printStream.println("Mic working");
    }
}
