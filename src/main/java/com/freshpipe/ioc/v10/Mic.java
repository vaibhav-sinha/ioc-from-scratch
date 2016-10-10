package com.freshpipe.ioc.v10;

/**
 * Created by vaibhav on 09/10/16.
 */
public class Mic {

    @Autowired
    private PrintStream printStream;

    public void say(String message) {
        printStream.println(message);
    }
}
