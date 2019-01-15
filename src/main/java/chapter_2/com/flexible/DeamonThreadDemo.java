package chapter_2.com.flexible;

public class DeamonThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true){
                try {
                Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        //设置守护线程
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle.");

    }
}
