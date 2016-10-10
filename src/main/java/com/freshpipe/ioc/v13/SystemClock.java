package com.freshpipe.ioc.v13;

import java.util.Date;

/**
 * Created by vaibhav on 10/10/16.
 */
public class SystemClock implements Clock {

    @Override
    public int getHours() {
        return new Date().getHours();
    }
}
