package state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname TestSleep3
 * @Description TODO
 * @Date 2020/12/8 9:54
 * @Created by mmz
 */
/*打印当前系统的时间*/
public class TestSleep3 {
    public static void main(String[] args) {
        // 获取系统当前时间
        Date time = new Date(System.currentTimeMillis());

        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(time));
                time = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
