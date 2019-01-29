package chapter_18.com.flexible;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * Description:测试一个非线程安全的累加器
 * User: chendom
 * Date: 2019-01-29
 * Time: 11:28
 */
public class IntegerAccumulator {

//    private int init;
    //使用不变的方式进行，每次线程操作都长生一个新的对象
private final int init;
    public IntegerAccumulator(int init) {
        this.init = init;
    }
    //构造累加器，需要使用到另外一个IntegerAccumulator
    public IntegerAccumulator(IntegerAccumulator accumulator,int init){
        this.init=accumulator.getValue()+init;
    }


    //对赋值进字增
    public IntegerAccumulator add(int i) {
        //不在原来的基础上累加，而是选择了创建一个新的对象.
        return new IntegerAccumulator(this,i);
    }

    //返回当前的初始值
    public int getValue() {
        return this.init;
    }

    public static void main(String[] args) {
        IntegerAccumulator accumulator = new IntegerAccumulator(0);
        //定义若干线程
        IntStream.range(0, 3).forEach(e -> new Thread(() -> {
            int inc = 0;
            while (true) {
                int oldValue;
                int result;
                //在操作数据的时候添加同步机制可以实现数据的同步不出错.
//                synchronized (IntegerAccumulator.class) {
                    //首先获得旧的值
                    oldValue = accumulator.getValue();
                    //调用add方法计算
                    result = accumulator.add(inc).getValue();
//                }

                    //经过验证，如果不合理，就输出错误信息
                    if (inc + oldValue != result) {
                        System.out.println("ERROR:" + oldValue + "+" + inc + "=" + result);
                    }
                    inc++;
                    slowly();

            }
        }).start());

    }

    private static void slowly() {
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
