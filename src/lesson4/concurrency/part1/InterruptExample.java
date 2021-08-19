package lesson4.concurrency.part1;

public class InterruptExample {

    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(() -> {
           for (int i = 0; i < 10; i++) {
               if (Thread.currentThread().isInterrupted()) {
                   break;
               }
               System.out.println(i);
               try {
                   Thread.sleep(50);
               } catch (InterruptedException e) {
                   e.printStackTrace();
                   break;
               }
           }
       });
       thread.start();
       Thread.sleep(100);
       thread.interrupt();
   }
}
