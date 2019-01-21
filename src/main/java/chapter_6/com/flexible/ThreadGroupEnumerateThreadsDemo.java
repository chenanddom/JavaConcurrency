package chapter_6.com.flexible;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreadsDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建一个线程组g1
        ThreadGroup g1 = new ThreadGroup("g1");
        //创建线程传入ThreadGroup g1
        Thread t1 = new Thread(g1,()->{
    while (true){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        },"t1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        mainGroup.list();
        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);
        recurseSize = mainGroup.enumerate(list,false);
        System.out.println(recurseSize);
    }
}
