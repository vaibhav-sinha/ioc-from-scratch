package com.freshpipe.ioc.v3;

import java.util.Date;

/**
 * Created by vaibhav on 09/10/16.
 */
public class AutoCue {

    private Date date;

    public AutoCue(Date date) {
        this.date = date;
    }

    public String getMessage() {
        int hour = date.getHours();
        if(hour < 12) {
            return "Good morning";
        }
        else {
            return "Good evening";
        }
    }
}
