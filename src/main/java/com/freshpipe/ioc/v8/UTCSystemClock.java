package com.freshpipe.ioc.v8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vaibhav on 10/10/16.
 */
public class UTCSystemClock implements Clock {

    @Override
    public int getHours() {
        System.out.println("Using UTC clock");
        Date date = new Date();
        return date.getHours() - 5;
    }
}
