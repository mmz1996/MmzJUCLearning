package syn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname SafeBank
 * @Description TODO
 * @Date 2020/12/8 15:22
 * @Created by mmz
 */
public class SafeBank {
    public static void main(String[] args) {
        AccountSafe accountSafe = new AccountSafe(100,"结婚基金");
        DrawingSafe me = new DrawingSafe(accountSafe,50,"你");
        DrawingSafe he = new DrawingSafe(accountSafe,100,"zhong");
        me.start();
        he.start();
    }

}
class AccountSafe{
    int money; // 余额
    String name; // 卡名
    public AccountSafe(int money,String name){
        this.money = money;
        this.name = name;
    }
}

class DrawingSafe extends Thread{
    AccountSafe accountSafe;
    int drawingMoney;
    int nowMoney;

    public DrawingSafe(AccountSafe accountSafe,int drawingMoney,String name){
        super(name);
        this.accountSafe = accountSafe;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public  void run() {

        // 锁的东西，是变化的东西
        synchronized (accountSafe){
            System.out.println(Thread.currentThread().getName()+  "线程开始");
            if((accountSafe.money - drawingMoney) < 0){
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }

            try {
                if(Thread.currentThread().getName().equals("你")){
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "线程执行了");
            accountSafe.money =accountSafe.money-drawingMoney;
            nowMoney += drawingMoney;
            System.out.println(accountSafe.name +"余额为"  + accountSafe.money);
            System.out.println(this.getName() + "手里的钱" + this.nowMoney);

        }

    }
}