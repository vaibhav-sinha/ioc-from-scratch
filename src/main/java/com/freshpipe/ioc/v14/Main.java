package com.freshpipe.ioc.v14;

/**
 * Created by vaibhav on 09/10/16.
 * IOC version with proxies
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Registry.setConfig(Config.class);
        NewsReader newsReader = Registry.get(NewsReader.class);
        newsReader.readNews();
    }
}
