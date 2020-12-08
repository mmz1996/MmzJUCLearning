package state;

/**
 * @Classname TestState
 * @Description TODO
 * @Date 2020/12/8 10:20
 * @Created by mmz
 */
/*观察测试线程的状态*/
public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("-----");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state); // new

        // 观察启动
        thread.start();
        state = thread.getState();
        System.out.println(state); // 运行

        while (state != Thread.State.TERMINATED){ // 只要线程不终止就一直输出状态
            try {
                Thread.sleep(1000);
                state = thread.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
