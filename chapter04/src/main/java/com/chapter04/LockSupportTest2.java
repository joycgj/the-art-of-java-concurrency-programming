package com.chapter04;

import java.util.concurrent.locks.LockSupport;

// 详解JUC之锁——LockSupport类（04）
// https://blog.csdn.net/TimHeath/article/details/71643422
public class LockSupportTest2 {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        System.out.println("unpark...");
        LockSupport.unpark(mainThread);

        System.out.println("park 1");
        LockSupport.park();

        System.out.println("park 2");
        LockSupport.park();
    }
}
