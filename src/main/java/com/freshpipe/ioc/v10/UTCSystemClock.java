package com.freshpipe.ioc.v10;

import java.util.Date;

/**
 * Created by vaibhav on 10/10/16.
 */
public class UTCSystemClock implements Clock {

    private int difference = 5;

    public void setDifference(int difference) {
        this.difference = difference;
    }

    @Override
    public int getHours() {
        System.out.println("Using UTC clock with difference = " + difference);
        Date date = new Date();
        return date.getHours() - difference;
    }
}
