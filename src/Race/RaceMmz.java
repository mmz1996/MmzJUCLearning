package Race;

/**
 * @Classname RaceMmz
 * @Description TODO
 * @Date 2020/12/7 16:07
 * @Created by mmz
 */
public class RaceMmz implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("rabbit") && (i%10 == 0)){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(winner != null){
                break;
            }else if(i >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is" + winner);
            }
            System.out.println(Thread.currentThread().getName() + "已经走了" + i + "步");
        }
    }

    public static void main(String[] args) {
        RaceMmz raceMmz = new RaceMmz();
        new Thread(raceMmz,"rabbit").start();
        new Thread(raceMmz,"wugui").start();


    }

}
