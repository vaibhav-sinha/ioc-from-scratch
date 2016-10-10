package com.freshpipe.ioc.v7;

/**
 * Created by vaibhav on 09/10/16.
 */
public class NewsReader {

    private AutoCue autoCue;
    private Glasses glasses;
    private Mic mic;

    public NewsReader(AutoCue autoCue, Glasses glasses, Mic mic) {
        this.autoCue = autoCue;
        this.glasses = glasses;
        this.mic = mic;
        System.out.println("Created new NewsReader");
    }

    public void readNews() {
        String message = autoCue.getMessage();
        message = glasses.magnify(message);
        mic.say(message);
    }
}
