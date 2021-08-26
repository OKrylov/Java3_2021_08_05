package lesson4.concurrency.part1;

import java.util.concurrent.atomic.AtomicInteger;

public class Increment {

    private int value;
    private static int staticValue;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final Object incrementLock = new Object();
//    private Object printLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Increment increment1 = new Increment();
        Increment increment2 = new Increment();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment1.incrementValue();
                increment1.printValue();
                sleep(10);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment1.incrementValue();
                increment1.printValue();
//                increment2.incrementValue();
//                increment2.printValue();
                sleep(10);
            }
        }, "t2");


        t1.start();
        t2.start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void incrementValue() {
        atomicInteger.incrementAndGet();
//        synchronized (incrementLock) {
//            ++value;
//        }

//        synchronized (Increment.class) {
//            staticValue++;
//        }
    }

    private void printValue() {
        System.out.println(Thread.currentThread().getName() + " data = " + atomicInteger.get());
//        System.out.println(Thread.currentThread().getName() + " data = " + value);
//        System.out.println(Thread.currentThread().getName() + " data = " + staticValue);
    }
}