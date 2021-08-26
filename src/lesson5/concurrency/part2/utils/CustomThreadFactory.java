package lesson5.concurrency.part2.utils;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {

    private final String threadNamePrefix;
    private int counter = 0;

    public CustomThreadFactory(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, String.format("%s - %d", threadNamePrefix, counter++));
//        thread.setDaemon(true);
        return thread;
    }
}
