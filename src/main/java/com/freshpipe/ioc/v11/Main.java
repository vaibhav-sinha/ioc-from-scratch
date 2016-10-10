package com.freshpipe.ioc.v11;

/**
 * Created by vaibhav on 09/10/16.
 * IOC version with PostConstruct
 */
public class Main {
    public static void main(String[] args) throws Exception {
        NewsReader newsReader = Registry.get(NewsReader.class);
        newsReader.readNews();
    }
}
