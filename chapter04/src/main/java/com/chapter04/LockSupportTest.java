package com.chapter04;

import java.util.concurrent.locks.LockSupport;

// 详解JUC之锁——LockSupport类（04）
// https://blog.csdn.net/TimHeath/article/details/71643422
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                person.walk();
            }
        }, "Jason");
        thread.start();

        Thread.sleep(3000);

        System.out.println("三秒过去，我解救" + thread.getName());
        LockSupport.unpark(thread);//解除该线程阻塞
    }
}

class Person {
    public void walk() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName() + "在走...前面有人挡住了");
        LockSupport.park(); // 阻塞当前线程
        System.out.println(currentThread.getName() + "又可以走了");
    }
}