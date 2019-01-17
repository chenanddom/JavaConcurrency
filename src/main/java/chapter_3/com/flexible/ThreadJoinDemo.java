package chapter_3.com.flexible;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-16
 * Time: 8:36
 */
public class ThreadJoinDemo {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(1,3)
                .mapToObj(ThreadJoinDemo::create).collect(Collectors.toList());
         threadList.forEach(Thread::start);
        for (Thread t:threadList) {
            //如果注释当前的代码，会使得三个线程交替出现，
            // 否则闲使得当前的两个线程交替出现，等这两个线程执行完成之后再执行主线程
            t.join();
        }
        //线程运行再调用join
        for (Thread t:threadList) {
            t.join();
        }

        for (int i=10;i>0;i--){
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }

    private static Thread create(int seq) {
        return new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        });
    }
    private static void shortSleep(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
        e.printStackTrace();
        }
    }
}
