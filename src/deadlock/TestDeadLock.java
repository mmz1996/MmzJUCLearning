package deadlock;

/**
 * @Classname TestDeadLock
 * @Description TODO
 * @Date 2020/12/8 15:47
 * @Created by mmz
 */
public class TestDeadLock {
    public static void main(String[] args) {
        Object locka = new Object();
        Object lockb = new Object();

        AThread aThread = new AThread(locka,lockb);
        BThread bThread = new BThread(locka,lockb);

        new Thread(aThread,"a").start();
        new Thread(bThread,"b").start();
    }
}

class AThread implements Runnable{
    private Object locka;
    private Object lockb;
    AThread(Object locka,Object lockb){
        this.locka = locka;
        this.lockb = lockb;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动了");
        synchronized (locka){
            System.out.println(Thread.currentThread().getName() + "获取了a的锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "准备获取b的锁");
            synchronized (lockb){
                System.out.println("获取b的锁了");
            }
        }
    }
}

class BThread implements Runnable{
    private Object locka;
    private Object lockb;
    BThread(Object locka,Object lockb){
        this.locka = locka;
        this.lockb = lockb;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "启动了");
        synchronized (lockb){
            System.out.println(Thread.currentThread().getName() + "获取了b的锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "准备获取a的锁");
            synchronized (locka){
                System.out.println("获取a的锁了");
            }
        }
    }
}