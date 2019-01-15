package chapter_3.com.flexible;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-15
 * Time: 8:24
 */
public class Demo {


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100);
        TimeUnit.HOURS.sleep(5);
        TimeUnit.MINUTES.sleep(30);
        TimeUnit.SECONDS.sleep(25);
        TimeUnit.MILLISECONDS.sleep(100);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t1.setPriority(6);

    }
}
