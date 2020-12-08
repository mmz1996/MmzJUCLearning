/**
 * @Classname TestNewThread3
 * @Description TODO
 * @Date 2020/12/7 15:45
 * @Created by mmz
 */
public class TestNewThread3 implements Runnable {
    private int ticket = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            System.out.println(Thread.currentThread().getName() +  "当前剩余的票数为" + ticket--);

            if(ticket <= 0 ){
                System.out.println("当前已经没有票了");
                flag = false;
                break;
            }
        }

    }

    public static void main(String[] args) {
        TestNewThread3 ticket = new TestNewThread3();

        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();

    }
}
