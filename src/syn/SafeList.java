package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SafeList
 * @Description TODO
 * @Date 2020/12/8 15:32
 * @Created by mmz
 */
public class SafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size()); // 结果应该小于1000
    }
}
