package lesson4.concurrency.part1;

import java.util.concurrent.TimeUnit;

public class PrintABApp {

    private volatile char currentLetter = 'A';

    private final Object monitor = new Object();

    public static void main(String[] args) {
        PrintABApp waitNotifyApp = new PrintABApp();
        new Thread(() -> {
            waitNotifyApp.printA();
        }).start();
        new Thread(() -> {
            waitNotifyApp.printB();
        }).start();
    }

    public void printA() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (currentLetter != 'A') {
//                        monitor.wait();
                        monitor.wait(5000);
                    }
                    System.out.print("A");
                    currentLetter = 'B';
                    monitor.notify();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            for (int i = 0; i < 10; i++) {
                try {
                    while (currentLetter != 'B') {
//                        monitor.wait();
                        monitor.wait(5000);
                    }
                    System.out.print("B");
                    currentLetter = 'A';
//                    monitor.notify();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
