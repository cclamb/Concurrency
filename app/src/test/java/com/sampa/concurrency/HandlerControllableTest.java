package com.sampa.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cclamb on 7/18/15.
 */
public class HandlerControllableTest {

    @Test
    public void testRun() throws Exception {
        HandlerControllable c = new HandlerControllable();
        c.start();
        Thread.sleep(10000);
        c.stop();
        assertTrue(c.getCount() > 0);
    }

}