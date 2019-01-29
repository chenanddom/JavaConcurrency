package chapter_10.com.flexible;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-23
 * Time: 12:35
 */
public class Demo {
    private int a;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demo demo = (Demo) o;

        return a == demo.a;
    }

    @Override
    public int hashCode() {
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Bootstra[:"+String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));
        System.out.println(Demo.class.getClassLoader());
    }
    @Test
    public void testMehod2(){


        String s = "030320331";

        int i = s.indexOf("03032033");
        System.out.println(s.substring("03032033".length(),s.length()));

    }


}
