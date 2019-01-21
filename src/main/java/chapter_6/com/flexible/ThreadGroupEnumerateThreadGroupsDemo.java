package chapter_6.com.flexible;

import java.util.concurrent.TimeUnit;

public class ThreadGroupEnumerateThreadGroupsDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup g1 = new ThreadGroup("g1");
        ThreadGroup g2 = new ThreadGroup(g1,"g2");
        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup[] list = new ThreadGroup[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);
        recurseSize = mainGroup.enumerate(list,false);
        System.out.println(recurseSize);
    }
}
