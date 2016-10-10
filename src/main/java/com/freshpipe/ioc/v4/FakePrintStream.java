package com.freshpipe.ioc.v4;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by vaibhav on 10/10/16.
 */
public class FakePrintStream extends PrintStream {

    private String messageToExpect;

    public FakePrintStream() {
        super(System.out);
    }

    public void setMessageToExpect(String messageToExpect) {
        this.messageToExpect = messageToExpect;
    }

    @Override
    public void println(String x) {
        if(messageToExpect.equals(x)) {
            super.println(x);
            super.println("Test Passed");
        }
        else {
            super.println("Test Failed");
            super.println("Expected: " + messageToExpect);
            super.println("Got: " + x);
        }
    }
}
