package com.freshpipe.ioc.v4;

/**
 * Created by vaibhav on 10/10/16.
 */
public class MainTest {

    public static void main(String[] args) {
        FakeClock fakeClock = new FakeClock();
        FakePrintStream fakePrintStream = new FakePrintStream();

        AutoCue autoCue = new AutoCue(fakeClock);
        Glasses glasses = new Glasses();
        Mic mic = new Mic(fakePrintStream);
        NewsReader newsReader = new NewsReader(autoCue, glasses, mic);

        //Tests
        fakeClock.setHour(11);
        fakePrintStream.setMessageToExpect("GOOD MORNING");
        newsReader.readNews();
        fakeClock.setHour(13);
        fakePrintStream.setMessageToExpect("GOOD EVENING");
        newsReader.readNews();
    }
}
