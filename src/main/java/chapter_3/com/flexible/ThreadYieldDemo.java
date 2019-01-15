package chapter_3.com.flexible;

import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-15
 * Time: 9:01
 */
public class ThreadYieldDemo {

    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(ThreadYieldDemo::create).forEach(Thread::start);
    }
    private static Thread create(int index){
        return new Thread(()->{
           if (index==0)
               Thread.yield();//放弃CPU资源
            System.out.println(index);
        });
    }
}
