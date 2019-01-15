package chapter_2.com.flexible;

public class ThreadGroupDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t1.start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("mainGroup:"+threadGroup.getName());
        Thread t2 = new Thread(new ThreadGroup("demo"), new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println("t1 threadGroup:"+t1.getThreadGroup().getName());
        System.out.println("t2 threadGroup:"+t2.getThreadGroup().getName());
    }
}
