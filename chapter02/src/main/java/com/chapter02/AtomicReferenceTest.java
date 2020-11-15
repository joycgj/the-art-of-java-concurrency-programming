package com.chapter02;

import java.util.concurrent.atomic.AtomicReference;

// Java AtomicReference Example
// https://examples.javacodegeeks.com/core-java/util/concurrent/atomic/atomicreference/java-atomicreference-example/
public class AtomicReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        final Person person = new Person("Tom", 18);
        System.out.println("Person is " + person);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                person.setAge(person.getAge() + 1);
                person.setName("Tom1");

                System.out.println("Thread1, " + person);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                person.setAge(person.getAge() + 2);
                person.setName("Tom2");
                System.out.println("Thread2, " + person);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Now person is " + person);

        final Person person2 = new Person("Tom", 18);
        AtomicReference<Person> atomicPerson = new AtomicReference<>(person2);

        System.out.println("Atomic Person is " + atomicPerson.get());
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicPerson.getAndSet(new Person("Tom1", atomicPerson.get().getAge() + 1));
                System.out.println("Thread3 Atomic Reference, " + atomicPerson.get());
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicPerson.getAndSet(new Person("Tom2", atomicPerson.get().getAge() + 2));
                System.out.println("Thread4 Atomic Reference, " + atomicPerson.get());
            }
        });

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Now Atomic Person is " + atomicPerson.get());
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "[name: " + this.name + ", age: " + this.age + "]";
    }
}
