package com.freshpipe.ioc.v14;

/**
 * Created by vaibhav on 09/10/16.
 */
public class Glasses {

    private boolean magnify = true;

    public void setMagnify(boolean magnify) {
        this.magnify = magnify;
    }

    public String magnify(String message) {
        if(magnify) {
            return message.toUpperCase();
        }
        else {
            return message.toLowerCase();
        }
    }
}
