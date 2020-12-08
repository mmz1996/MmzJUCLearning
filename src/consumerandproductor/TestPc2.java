package consumerandproductor;

/**
 * @Classname TestPc2
 * @Description TODO
 * @Date 2020/12/8 17:37
 * @Created by mmz
 */
/*利用信号灯法，来解决生产者消费者的问题，利用标志位*/
public class TestPc2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Actor(tv).start();
        new Watcher(tv).start();
    }
}

class Actor extends Thread{
    TV tv;
    public Actor(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2 == 0){
                this.tv.play("快乐大本营播放中");
            }else{
                this.tv.play("抖音记录美好生活");
            }
        }
    }
}
class Watcher extends Thread{
    TV tv;
    public Watcher(TV tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}
class TV{
    // 演员表演，观众等待

    String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了"+ voice);
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了"+voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}