package com.freshpipe.ioc.v2;

import java.util.Date;

/**
 * Created by vaibhav on 09/10/16.
 */
public class AutoCue {

    public String getMessage() {
        int hour = new Date().getHours();
        if(hour < 12) {
            return "Good morning";
        }
        else {
            return "Good evening";
        }
    }
}
