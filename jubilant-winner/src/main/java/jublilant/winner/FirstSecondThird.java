package jublilant.winner;

import java.util.concurrent.Semaphore;

/**
 * 说明
 *
 * @author zenuo
 * @date 2019/05/23
 */
public class FirstSecondThird {
    private Semaphore sem1, sem2;

    private FirstSecondThird() {
        try {
            sem1 = new Semaphore(1);
            sem2 = new Semaphore(1);

            sem1.acquire();
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void first() {
        sem1.release();
        System.out.println("first");
    }

    private void second() {
        try {
            sem1.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem1.release();
        sem2.release();
        System.out.println("second");
    }

    private void third() {
        try {
            sem2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem2.release();
        System.out.println("third");
    }

    public static void main(String[] args) throws InterruptedException {
        final FirstSecondThird firstSecondThird = new FirstSecondThird();
        new Thread(firstSecondThird::first).start();
        new Thread(firstSecondThird::second).start();
        new Thread(firstSecondThird::third).start();
    }
}
