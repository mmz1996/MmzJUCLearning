package state;

/**
 * @Classname TestYield
 * @Description TODO
 * @Date 2020/12/8 10:01
 * @Created by mmz
 */
public class TestYield implements Runnable {
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("我是线程" + Thread.currentThread().getName() + "准备休眠");
                Thread.sleep(5000);
                System.out.println("休眠结束了，我要开始礼让了");
                Thread.yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestYield testYield = new TestYield();
        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();
    }
}
