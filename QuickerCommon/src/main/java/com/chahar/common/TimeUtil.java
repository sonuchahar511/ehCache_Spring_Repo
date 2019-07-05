package com.chahar.common;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class TimeUtil {

    public static void main(String arg[]) {
        final Stopwatch stopWatch = Stopwatch.createStarted();
        stopWatch.elapsed(TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopWatch.stop();

        System.out.println(stopWatch.toString());
    }

    public static void slowQuery(final long seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
