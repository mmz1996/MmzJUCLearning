package state;

/**
 * @Classname TestSleep
 * @Description TODO
 * @Date 2020/12/8 9:45
 * @Created by mmz
 */
/*模拟网络延时*/
public class TestSleep implements Runnable {
    private static int ticket = 10;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ticket <=0){
                System.out.println("已经没有票了");
                break;
            }else{
                System.out.println(Thread.currentThread().getName()+ "得到了" + ticket--);
            }
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"a").start();
        new Thread(testSleep,"b").start();
        new Thread(testSleep,"c").start();
    }
}
