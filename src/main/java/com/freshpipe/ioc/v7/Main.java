package com.freshpipe.ioc.v7;

/**
 * Created by vaibhav on 09/10/16.
 * IOC version Registry and Scopes
 */
public class Main {
    public static void main(String[] args) throws Exception {
        NewsReader newsReader1 = Registry.get(NewsReader.class);
        newsReader1.readNews();

        NewsReader newsReader2 = Registry.get(NewsReader.class);
        newsReader2.readNews();
    }
}
