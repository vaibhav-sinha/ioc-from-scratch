package com.freshpipe.ioc.v2;

/**
 * Created by vaibhav on 09/10/16.
 */
public class NewsReader {

    public void readNews() {
        AutoCue autoCue = new AutoCue();
        String message = autoCue.getMessage();
        Glasses glasses = new Glasses();
        message = glasses.magnify(message);
        Mic mic = new Mic();
        mic.say(message);
    }
}
