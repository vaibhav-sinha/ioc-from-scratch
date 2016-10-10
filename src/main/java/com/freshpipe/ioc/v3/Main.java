package com.freshpipe.ioc.v3;

import java.util.Date;

/**
 * Created by vaibhav on 09/10/16.
 * Simple IOC version
 */
public class Main {
    public static void main(String[] args) {
        AutoCue autoCue = new AutoCue(new Date());
        Glasses glasses = new Glasses();
        Mic mic = new Mic(System.out);
        NewsReader newsReader = new NewsReader(autoCue, glasses, mic);
        newsReader.readNews();
    }
}
