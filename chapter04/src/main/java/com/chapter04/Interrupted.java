package com.chapter04;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws InterruptedException {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());

        // 防止 sleepThread 和 busyThread 立刻退出
        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}

/**
 * SleepThread interrupted is false
 * BusyThread interrupted is true
 * java.lang.InterruptedException: sleep interrupted
 * 	    at java.lang.Thread.sleep(Native Method)
 * 	    at java.lang.Thread.sleep(Thread.java:340)
 * 	    at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 * 	    at com.chapter04.SleepUtils.second(SleepUtils.java:8)
 * 	    at com.chapter04.Interrupted$SleepRunner.run(Interrupted.java:33)
 * 	    at java.lang.Thread.run(Thread.java:748)
 */
