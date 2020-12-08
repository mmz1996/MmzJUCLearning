package Race;

/**
 * @Classname race
 * @Description TODO
 * @Date 2020/12/7 15:57
 * @Created by mmz
 */
public class Race implements Runnable {
    private static String winner = null;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {

            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" +  i + "步");
        }
    }

    // 判断是否完成比赛
    private boolean gameOver(int steps){
        if(winner != null){
            return false;
        }else if(steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winnner is " + winner);
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"rabbit").start();
        new Thread(race,"wugui").start();

    }
}
