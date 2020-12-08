package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UnsafeList
 * @Description TODO
 * @Date 2020/12/8 15:05
 * @Created by mmz
 */
/*线程不安全的list*/
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size()); // 结果应该小于1000
    }
}
