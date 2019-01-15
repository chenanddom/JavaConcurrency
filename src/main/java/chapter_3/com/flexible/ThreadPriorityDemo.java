package chapter_3.com.flexible;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-15
 * Time: 9:34
 */
public class ThreadPriorityDemo {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println("t1 priority:"+t1.getPriority());
        Thread t2 = new Thread(()->{
            Thread t3 = new Thread();//子线程的优先级依赖父线程的优先级
            System.out.println("t3 priority:"+t3.getPriority());

        });
        t2.setPriority(6);
        t2.start();
        System.out.println("t2 priority:"+t2.getPriority());
        System.out.println("thread Id:"+t1.getId());
    }
}
