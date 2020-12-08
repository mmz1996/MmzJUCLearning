/**
 * @Classname TestNewThread1
 * @Description TODO
 * @Date 2020/12/3 17:06
 * @Created by mmz
 */
    // 创建线程方式一：继承Thread类，重写run方法，调用start开启线程
    // 线程开启不一定立即执行
public class TestNewThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码"+i);
        }
    }

    public static void main(String[] args) {
        TestNewThread1 testNewThread1 = new TestNewThread1();
        testNewThread1.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程"+i);
        }
    }
}
