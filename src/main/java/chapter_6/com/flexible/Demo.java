package chapter_6.com.flexible;

/**
 * ThreadGroup的代码
 */
public class Demo {

    public static void main(String[] args) {
        //获取当前线程所属的线程组
        ThreadGroup g1 = Thread.currentThread().getThreadGroup();
        //定义一个线程组
        ThreadGroup g2 = new ThreadGroup("g2");
        //判断当前线程所属的线程组的父线程
        System.out.println(g2.getParent()==g1);//true
        //定义新得线程，在之前得线程组之上
        ThreadGroup g3 = new ThreadGroup(g2,"g3");
        System.out.println(g3.getParent()==g2);//true
    }
}


