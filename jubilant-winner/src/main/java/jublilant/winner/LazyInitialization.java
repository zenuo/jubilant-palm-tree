package jublilant.winner;

import java.util.concurrent.TimeUnit;

/**
 * 懒加载
 *
 * @author zenuo
 * @date 2019/06/05
 */
public class LazyInitialization {
    public static Helper getHelper() {
        return HelperHolder.helper;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Timed wait");
        TimeUnit.SECONDS.sleep(2L);
        System.out.println(getHelper());
    }

    private static class HelperHolder {
        static final Helper helper = new Helper();

        static {
            System.out.println("Initialization");
        }
    }
}

class Helper {
    public static void main(String[] args) {
        System.out.println("Helper");
    }
}

/* output:
Timed wait
Initialization
jublilant.winner.Helper@6b143ee9
 */