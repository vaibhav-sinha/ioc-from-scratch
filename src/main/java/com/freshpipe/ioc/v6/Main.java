package com.freshpipe.ioc.v6;

/**
 * Created by vaibhav on 09/10/16.
 * Simple IOC version with Interfaces and Generic Factory
 */
public class Main {
    public static void main(String[] args) throws Exception {
        NewsReader newsReader = GenericFactory.create(NewsReader.class);
        newsReader.readNews();
    }
}
