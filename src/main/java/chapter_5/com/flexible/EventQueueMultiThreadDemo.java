package chapter_5.com.flexible;

import org.junit.Test;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-18
 * Time: 9:49
 */
public class EventQueueMultiThreadDemo {

    private final int max;

    static class Event {

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueueMultiThreadDemo() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueueMultiThreadDemo(int max) {
        this.max = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            while (eventQueue.size() >= max) {
                try {
                    console("the queue is full");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            while (eventQueue.isEmpty()) {
                try {
                    console("the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console("the event " + event + " is handle.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s:%s\n", currentThread().getName(), message);
    }

    public static void main(String[] args) {
        final EventQueueMultiThreadDemo eventQueue = new EventQueueMultiThreadDemo();
        new Thread(() -> {
            while (true)
            eventQueue.offer(new EventQueueMultiThreadDemo.Event());
        }, "Producer").start();

        new Thread(() -> {
            while (true) {
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Consumer").start();

        new Thread(() -> {
            while (true) {
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Consumer2").start();
    }

    @Test
    public void testMethod(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {


            }
        });

    }
}
