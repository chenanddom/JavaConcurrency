package chapter_1.com.flexible;

/**
 * Created with IntelliJ IDEA.
 * Description:使用模板方法，在多綫程同樣使用了這個方法.如果存在如果传入Thread的是Runnable就是调用runnable的run,如果没有就需要重写run
 * User: chendom
 * Date: 2019-01-10
 * Time: 12:58
 */
public class TemplateDemo {

public final void modify(String msg){
    System.out.println("-----------------------");
    showInfo(msg);
    System.out.println("-----------------------");
}

public void showInfo(String msg){

}
    public static void main(String[] args) {
        TemplateDemo demo = new TemplateDemo(){
            @Override
            public void showInfo(String msg) {
                System.out.println("content:"+msg);
            }
        };
        demo.modify("hello world");
    }
}
