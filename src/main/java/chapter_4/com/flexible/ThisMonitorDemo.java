package chapter_4.com.flexible;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-17
 * Time: 8:49
 */
public class ThisMonitorDemo {
    public synchronized void method_1() {
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method_2() {
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method_3() {
        synchronized (this) {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThisMonitorDemo demo = new ThisMonitorDemo();
        Thread t1 = new Thread(demo::method_1, "T1");
        Thread t2 = new Thread(demo::method_2, "T2");
        Thread t3 = new Thread(demo::method_2, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
