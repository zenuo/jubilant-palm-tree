package jublilant.winner;

public class Increament {
    public static void main(String[] args) {
        primitive();
        wrapper();
    }

    /**
     *  0 iconst_0
     *  1 istore_0
     *  2 iinc 0 by 1
     *  5 getstatic #4 <java/lang/System.out>
     *  8 iload_0
     *  9 invokevirtual #5 <java/io/PrintStream.println>
     * 12 return
     */
    private static void primitive() {
        int i = 0;
        i++;
        System.out.println(i);
    }


    /**
     *  0 iconst_0
     *  1 invokestatic #6 <java/lang/Integer.valueOf>
     *  4 astore_0
     *  5 aload_0
     *  6 astore_1
     *  7 aload_0
     *  8 invokevirtual #7 <java/lang/Integer.intValue>
     * 11 iconst_1
     * 12 iadd
     * 13 invokestatic #6 <java/lang/Integer.valueOf>
     * 16 dup
     * 17 astore_0
     * 18 astore_2
     * 19 aload_1
     * 20 pop
     * 21 getstatic #4 <java/lang/System.out>
     * 24 aload_0
     * 25 invokevirtual #8 <java/io/PrintStream.println>
     * 28 return
     */
    private static void wrapper() {
        Integer i = 0;
        i++;
        System.out.println(i);
    }
}
