package zenuo.jublilant.winner;

/**
 * 说明
 *
 * http://journals.ecs.soton.ac.uk/java/tutorial/java/threads/example/SelfishRunner.java
 *
 * @author zenuo
 * @date 2019/05/23
 */
public class SelfishRunner extends Thread {
    public int tick = 1;
    public int num;

    SelfishRunner(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (tick < 400000) {
            tick++;
            if ((tick % 50000) == 0) {
                System.out.println("Thread #" + num + ", tick = " + tick);
            }
        }
    }

    final static int NUMRUNNERS = 2;

    public static void main(String[] args) {

        SelfishRunner[] runners = new SelfishRunner[NUMRUNNERS];

        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new SelfishRunner(i);
            runners[i].setPriority(2);
        }
        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i].start();
        }
    }
}
