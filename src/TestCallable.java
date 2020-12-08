import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname TestCallable
 * @Description TODO
 * @Date 2020/12/7 16:20
 * @Created by mmz
 */
public class TestCallable implements Callable {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i<100 ; i++){
            System.out.println(Thread.currentThread().getName()+ " " + i );
        }

        return i ;
    }

    public static void main(String[] args) {
        TestCallable testCallable = new TestCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(testCallable);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " "+ i);
            if(i == 20){
                new  Thread(futureTask,"callable线程").start();
            }
        }

        try {
            System.out.println("子线程的返回值是" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
