package com.freshpipe.ioc.v11;

/**
 * Created by vaibhav on 09/10/16.
 */
public class AutoCue {

    @Autowired
    private Clock clock;

    public String getMessage() {
        int hour = clock.getHours();
        if(hour < 12) {
            return "Good morning";
        }
        else {
            return "Good evening";
        }
    }
}
