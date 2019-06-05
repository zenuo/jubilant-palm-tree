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
        System.out.println("等待");
        TimeUnit.SECONDS.sleep(2L);
        System.out.println(getHelper());
    }

    private static class HelperHolder {
        public static final Helper helper = new Helper();

        static {
            System.out.println("加载");
        }
    }
}

class Helper {
    public static void main(String[] args) {
        System.out.println("Helper");
    }
}
