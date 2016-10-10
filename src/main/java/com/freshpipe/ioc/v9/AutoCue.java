package com.freshpipe.ioc.v9;

/**
 * Created by vaibhav on 09/10/16.
 */
public class AutoCue {

    private Clock clock;

    public AutoCue(Clock clock) {
        this.clock = clock;
    }

    public String getMessage() {
        int hour = clock.getHours();
        if(hour < 12) {
            return "Good morning";
        }
        else {
            return "Good evening";
        }
    }
}
