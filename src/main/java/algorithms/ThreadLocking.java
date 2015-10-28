package algorithms;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * Created by Itai on 25-Sep-15.
 */
public class ThreadLocking {
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1);

        IntStream.range(0, 10)
                .forEach(i -> {
                    try {
                        Thread t = new Thread(() -> {
                            incCount();
                            System.out.println("Thread " + i + " finished running!");
                            semaphore.release();
                        });
                        semaphore.acquire();
                        t.start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void incCount() {
        count++;
        System.out.println("Count = " + count);
    }
}
