package com.freshpipe.ioc.v4;

/**
 * Created by vaibhav on 10/10/16.
 */
public class FakeClock implements Clock {

    private int hours;

    public void setHour(int hours) {
        this.hours = hours;
    }

    @Override
    public int getHours() {
        return hours;
    }
}
