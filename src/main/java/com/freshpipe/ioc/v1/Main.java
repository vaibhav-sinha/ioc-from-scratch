package com.freshpipe.ioc.v1;


import java.util.Date;

/**
 * Created by vaibhav on 09/10/16.
 * Non OO version
 */
public class Main {
    public static void main(String[] args) {
        int hour = new Date().getHours();
        String message;
        if(hour < 12) {
            message = "Good morning";
        }
        else {
            message = "Good evening";
        }
        message = message.toUpperCase();
        System.out.println(message);
    }
}
