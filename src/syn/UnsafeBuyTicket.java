package syn;

/**
 * @Classname UnsafeBuyTicket
 * @Description TODO
 * @Date 2020/12/8 11:12
 * @Created by mmz
 */
/*不安全的买票的方法*/
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"a").start();
        new Thread(buyTicket,"b").start();
        new Thread(buyTicket,"c").start();
    }
}

class BuyTicket implements Runnable{
    private int ticket = 5;
    boolean flag = true;
    @Override
    public void run() {
        // 买票
        while(flag){
            buy();
        }
    }

    private void buy(){
        // 判断是否有票
        if(ticket <=0 ){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+ "拿到" +ticket--);
    }
}
