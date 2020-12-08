package state;

/**
 * @Classname TestStop
 * @Description TODO
 * @Date 2020/12/8 9:34
 * @Created by mmz
 */
// 建议线程正常停止——>利用次数，不建议死循环
// 建议使用标志位，设置一个标志位
// 不要使用stop，destroy等过时的方法

public class TestStop implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("线程正在运行" + i++);
        }
    }

    // 设置一个公开的方法，转换标志位
    public void stop(){
        this.flag = false;
    }
    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000000; i++) {
//            System.out.println("main" + i);
            if(i == 90000){
                testStop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}
