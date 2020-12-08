/**
 * @Classname TestNewThread2
 * @Description TODO
 * @Date 2020/12/7 15:37
 * @Created by mmz
 */
public class TestNewThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("我是runnable类");
    }

    public static void main(String[] args) {
        TestNewThread2 testNewThread2 = new TestNewThread2();
        Thread thread = new Thread(testNewThread2);
        thread.start();

    }
}
