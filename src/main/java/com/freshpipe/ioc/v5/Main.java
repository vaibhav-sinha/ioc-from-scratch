package com.freshpipe.ioc.v5;

/**
 * Created by vaibhav on 09/10/16.
 * Simple IOC version with Interfaces and Factories
 */
public class Main {
    public static void main(String[] args) {
        NewsReader newsReader = NewsReaderFactory.create();
        newsReader.readNews();
    }
}
