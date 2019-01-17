package chapter_3.com.flexible;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-16
 * Time: 9:05
 */
public class ThreadInterruptExitDemo {

    public static void main(String[] args) throws InterruptedException {
/*        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
                while (!isInterrupted()) {
                    System.out.println("I am working");
                }
                System.out.println("I will be exiting");
            }
        };
        t.start();
        TimeUnit.NANOSECONDS.sleep(1);
        System.out.println("I will be shutdown.");
        t.interrupt();*/

        MyTask t = new MyTask();
        t.start();
        TimeUnit.MILLISECONDS.sleep(1);
        System.out.println("System will be shutdown.");
        t.close();
    }

    static class MyTask extends Thread{
        private volatile boolean closed=false;
        @Override
        public void run() {
            System.out.println("I will start work");
            while (!closed && !isInterrupted()) {
                System.out.println("I am working");
            }
            System.out.println("I will be exiting");
        }
        public void close(){
            this.closed=true;
            this.interrupt();
        }

    }

    @Test
    public void testClose() throws InterruptedException {

    }

}
