package com.freshpipe.ioc.v8;

/**
 * Created by vaibhav on 09/10/16.
 * IOC version Specify concrete types
 */
public class Main {
    public static void main(String[] args) throws Exception {
        NewsReader newsReader = Registry.get(NewsReader.class);
        newsReader.readNews();
    }
}
