package chapter_3.com.flexible;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-15
 * Time: 13:53
 */
public class ThreadInterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("receive interrupt msg");
            }
        });
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        t1.interrupt();//中断
    }
}
