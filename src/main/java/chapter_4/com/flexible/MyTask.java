package chapter_4.com.flexible;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-17
 * Time: 8:34
 */
public class MyTask implements Runnable {
    private static final Object MUTEX = new Object();
    @Override
    public void run() {
        synchronized (MUTEX){
            //...
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            new Thread(MyTask::new).start();
        }
    }
}
