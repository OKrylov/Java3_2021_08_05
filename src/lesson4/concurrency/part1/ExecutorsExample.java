package lesson4.concurrency.part1;

import java.util.concurrent.*;

public class ExecutorsExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Object lock = new Object();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newWorkStealingPool();

//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.scheduleAtFixedRate(() -> {
//            System.out.println("Hello!");
//        }, 0, 5, TimeUnit.SECONDS);
//
//        Runnable runnable = () -> {
//            try {
//                Thread.sleep(100);
//                System.out.printf("Hello, %s!\n", Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        };
//
//
//        for (int i = 0; i < 5; i++) {
////            executorService.execute(runnable);
//            int finalI = i;
//            Callable<Double> callable = () -> {
//                System.out.printf("Hello, %s!\n", Thread.currentThread().getName());
//                Thread.sleep(1000);
//                return Math.pow(2, finalI);
//            };
//            Future<Double> future = executorService.submit(callable);
////            System.out.println("result: " + future.get());
//            System.out.println("Is done: " + future.isDone());
//            System.out.println("result: " + future.get(5, TimeUnit.SECONDS));
//            System.out.println("Is done: " + future.isDone());
//        }


        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            lock.wait(2000);
            System.out.println("Finished");
            return "result";
        };

//        Thread.sleep(100);

        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }
//
        Thread.sleep(100);

        executorService.shutdown();
//        executorService.shutdownNow();
    }


}
