package syn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname UnsafeBank
 * @Description TODO
 * @Date 2020/12/8 12:42
 * @Created by mmz
 */
// 不安全的取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100,"结婚基金");
        Drawing you = new Drawing(account,50,"你");
        Drawing she = new Drawing(account,100,"zhong");
        you.start();
        she.start();
        ReentrantLock lock = new ReentrantLock();
    }
}

class Account{
    int money; // 余额
    String name; // 卡名
    public Account(int money,String name){
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account;
    int drawingMoney;
    int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+  "线程开始");
        if((account.money - drawingMoney) < 0){
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
        account.money =account.money-drawingMoney;
        nowMoney += drawingMoney;
        System.out.println(account.name +"余额为"  + account.money);
        System.out.println(this.getName() + "手里的钱" + this.nowMoney);

    }
}