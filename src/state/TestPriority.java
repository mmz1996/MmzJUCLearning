package state;

/**
 * @Classname TestPriority
 * @Description TODO
 * @Date 2020/12/8 10:30
 * @Created by mmz
 */
/*测试线程优先级*/
public class TestPriority extends Thread{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() +"-->" +Thread.currentThread().getPriority() );
        MyPriority myPriority = new MyPriority();
        Thread thread1 =  new Thread(myPriority);
        Thread thread2 =  new Thread(myPriority);
        Thread thread3 =  new Thread(myPriority);
        Thread thread4 =  new Thread(myPriority);
        Thread thread5 =  new Thread(myPriority);
        Thread thread6 =  new Thread(myPriority);

        thread1.start();

        thread2.setPriority(1);
        thread2.start();

        thread3.setPriority(4);
        thread3.start();

        thread4.setPriority(Thread.MAX_PRIORITY);
        thread4.start();

        thread5.setPriority(-1);
        thread5.start();

        thread6.setPriority(11);
        thread6.start();

    }
}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +"-->" +Thread.currentThread().getPriority() );
    }
}