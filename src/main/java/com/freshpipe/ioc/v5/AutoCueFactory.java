package com.freshpipe.ioc.v5;

/**
 * Created by vaibhav on 10/10/16.
 */
public class AutoCueFactory {

    public static AutoCue create() {
        return new AutoCue(new SystemClock());
    }
}
