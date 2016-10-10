package com.freshpipe.ioc.v5;

/**
 * Created by vaibhav on 10/10/16.
 */
public class NewsReaderFactory {

    public static NewsReader create() {
        return new NewsReader(AutoCueFactory.create(), GlassesFactory.create(), MicFactory.create());
    }
}
