package syn;

/**
 * @Classname SafeBuyTicket
 * @Description TODO
 * @Date 2020/12/8 15:14
 * @Created by mmz
 */
public class SafeBuyTicket {
    public static void main(String[] args) {
        BuySafeTicket buySafeTicket = new BuySafeTicket();
        new Thread(buySafeTicket,"a").start();
        new Thread(buySafeTicket,"b").start();
        new Thread(buySafeTicket,"c").start();
    }
}
class BuySafeTicket implements Runnable{
    private int ticket = 1000;
    boolean flag = true;
    @Override
    public void run() {
        // 买票
        while(flag){
            buy();
        }
    }

    // 同步方法，锁的是this
    private  synchronized void buy(){
        // 判断是否有票
        if(ticket <=0 ){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+ "拿到" +ticket--);
    }
}

