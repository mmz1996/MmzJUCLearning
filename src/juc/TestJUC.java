package juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Classname TestJUC
 * @Description TODO
 * @Date 2020/12/8 15:37
 * @Created by mmz
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                copyOnWriteArrayList.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(copyOnWriteArrayList.size());
    }
}
