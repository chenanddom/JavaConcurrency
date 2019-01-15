package chapter_3.com.flexible;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadInterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                //这里使用循环而不是使用sleep是因为sleep是可中断的(会收到中断信号，将中断的信号)，会干扰到程序运行的结果
         /*       while (true){
                    //....
                }*/
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.printf("I am be interrupted ? %s\n",isInterrupted());
                }
            }
        };

        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted? %s\n",t1.isInterrupted());
        t1.interrupt();
        System.out.printf("Thread is interrupted? %s\n",t1.isInterrupted());
    }
    @Test
    public void testInterrupted() throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true)
                System.out.println(Thread.interrupted());
            }
        };
        t1.setDaemon(true);
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        t1.interrupt();
    }
    @Test
    public void testInterrupted_2(){
        //判断当前线程是否被中断
        System.out.println("Main thread is interrupted?"+Thread.interrupted());
        //中断当前线程
        Thread.currentThread().interrupt();
        //判断当前线程是否被中断
        System.out.println("Main thread is interrupted?"+Thread.currentThread().isInterrupted());

        try {
            //当前线程可执行中断方法
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            //捕获线程中断信号
            System.out.println("I will  be interrupted still.");
        }
    }

}
