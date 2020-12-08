package state;

/**
 * @Classname TestSleep2
 * @Description TODO
 * @Date 2020/12/8 9:51
 * @Created by mmz
 */
/*模拟倒计时*/
public class TestSleep2 {
    public void tenDown(){
        int number = 10;
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(number--);
                if(number <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestSleep2 testSleep2 = new TestSleep2();
        testSleep2.tenDown();
    }
}
