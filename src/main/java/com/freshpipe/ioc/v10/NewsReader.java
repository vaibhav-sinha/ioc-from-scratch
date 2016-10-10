package com.freshpipe.ioc.v10;

/**
 * Created by vaibhav on 09/10/16.
 */
public class NewsReader {

    @Autowired
    private AutoCue autoCue;
    @Autowired
    private Glasses glasses;
    @Autowired
    private Mic mic;

    public void readNews() {
        String message = autoCue.getMessage();
        message = glasses.magnify(message);
        mic.say(message);
    }
}
