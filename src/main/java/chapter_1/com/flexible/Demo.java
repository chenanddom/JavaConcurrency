package chapter_1.com.flexible;

import java.util.concurrent.TimeUnit;

public class Demo {
    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("...........enjoyMusic.......");
            sleep(1);
        }
    }


    private static void browseNews() {
        for (; ; ) {
            System.out.println("...........browseNews.......");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                enjoyMusic();
            }
        };
        new Thread(runnable).start();
        browseNews();
    }
}
