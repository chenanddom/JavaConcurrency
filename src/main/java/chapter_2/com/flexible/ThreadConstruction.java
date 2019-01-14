package chapter_2.com.flexible;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-14
 * Time: 8:41
 */
public class ThreadConstruction {

    public static void main(String[] args) {
    if (args.length<1){
        System.out.println("please enter the stack size.");
        System.exit(1);
    }
    ThreadGroup group = new ThreadGroup("TestGroup");
    Runnable runnable = new Runnable() {
        final  int MAX = Integer.MAX_VALUE;
        @Override
        public void run() {
        int i=0;


            recurse(i);
        }

        private void recurse(int i){
            System.out.println(i);
            if (i<MAX);
            recurse(i+1);
        }

    };
    Thread thread = new Thread(group,runnable,"Demo",Integer.valueOf(args[0]));
    thread.start();

    }
}
