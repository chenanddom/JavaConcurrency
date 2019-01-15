package chapter_3.com.flexible;

public class ThreadDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
            while (true){

            }
            }
        }).start();
    }
}
