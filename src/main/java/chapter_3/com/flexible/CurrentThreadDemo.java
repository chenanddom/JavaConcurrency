package chapter_3.com.flexible;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-15
 * Time: 12:18
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1currentThread:"+Thread.currentThread().getName());
            }
        }).start();
        System.out.println("2currentThread:"+Thread.currentThread().getName());


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello demo");
            }
        });
        t2.start();
        System.out.println(t2.getContextClassLoader());

    }
}
