package jublilant.winner;

/**
 * 说明
 *
 * @author zenuo
 * @date 2019/05/23
 */
public class PoliteRunner extends Thread {
    public int tick = 1;
    public int num;

    PoliteRunner(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (tick < 400000) {
            tick++;
            if ((tick % 50000) == 0) {
                System.out.println("Thread #" + num + ", tick = " + tick);
                yield();
            }
        }
    }

    final static int NUMRUNNERS = 2;

    public static void main(String[] args) {

        PoliteRunner[] runners = new PoliteRunner[NUMRUNNERS];

        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new PoliteRunner(i);
            runners[i].setPriority(2);
        }
        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i].start();
        }
    }
}
