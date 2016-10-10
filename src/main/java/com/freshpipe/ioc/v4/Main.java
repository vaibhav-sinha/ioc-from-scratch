package com.freshpipe.ioc.v4;

import java.util.Date;

/**
 * Created by vaibhav on 09/10/16.
 * Simple IOC version with Interfaces
 */
public class Main {
    public static void main(String[] args) {
        AutoCue autoCue = new AutoCue(new SystemClock());
        Glasses glasses = new Glasses();
        Mic mic = new Mic(System.out);
        NewsReader newsReader = new NewsReader(autoCue, glasses, mic);
        newsReader.readNews();
    }
}
