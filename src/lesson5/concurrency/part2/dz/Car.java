package lesson5.concurrency.part2.dz;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static AtomicBoolean hasWinner = new AtomicBoolean(false);

    private Race race;
    private int speed;
    private String name;

    private CyclicBarrier waitForPrepareBarrier;
    private FinishNotifier finishNotifier;


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier waitForPrepareBarrier, FinishNotifier finishNotifier) {
        this.race = race;
        this.speed = speed;
        this.waitForPrepareBarrier = waitForPrepareBarrier;
        this.finishNotifier = finishNotifier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            prepare();
            waitWhileAllCarFinishedPreparing();
        } catch (Exception e) {
            e.printStackTrace();
        }

        startRace();
    }

    private void waitWhileAllCarFinishedPreparing() throws InterruptedException, BrokenBarrierException {
        waitForPrepareBarrier.await();
    }

    private void startRace() {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        checkWin();
        finishNotifier.notifyAboutFinished();
    }

    private void prepare() throws InterruptedException {
        System.out.println(this.name + " готовится");
        doPrepare();
        System.out.println(this.name + " готов");
    }

    private void doPrepare() throws InterruptedException {
        Thread.sleep(500 + (int) (Math.random() * 800));
    }

    private void checkWin() {
        if ( !hasWinner.getAndSet(true) ) {
            System.out.println(this.name + " - WIN");
        }
//        synchronized (hasWinner) {
//            if (hasWinner)
//                return;
//
//            System.out.println(this.name + " - WIN");
//            hasWinner = true;
//        }
    }
}