package chapter_9.com.flexible;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-23
 * Time: 9:36
 */
public class Demo {
    private static Demo demo = new Demo();

    private static int x=2;

    private  static int y=1;
    //静态代码块可以对前面的类变量赋值，操作，但是对后面的类变量只能赋值，不能操作
    static {
    y++;
        System.out.println("y:"+y);
    }
    private static int n=100;

    public Demo(){
        x++;
        y++;
    }
    public static Demo getInstance(){
        return demo;
    }
    public static void main(String[] args) {
        Demo instance = Demo.getInstance();
        System.out.println(instance.x);
        System.out.println(instance.y);
        System.out.println(instance.n);
    }
    @Test
    public void test(){
        String str = "33";
/*        System.out.println(str.substring(2,5));
        int i = str.indexOf("0");
        System.out.println(str.substring(0,i+1));*/

        System.out.println("str:"+generateDistrictCode(str));

    }

    public String generateDistrictCode(String code) {
        StringBuilder sb = new StringBuilder();
        if ("".equals(code) && code == null) {
            return null;
        }
        int length = code.length();
        String result = "";
        Integer v = null;
        String sub1 = "";
        String sub2 = "";
        switch (length) {
            case 2:
                v = Integer.valueOf(code);
                if (v < 9) {
                    v = v + 1;
                    sb.append("0").append(v);
                } else {
                    v = v + 1;
                    sb.append(v);
                }
                result = sb.toString();
                break;
            case 5:
                sub1 = code.substring(0, 2);
                sub2 = code.substring(2, length);
                v = Integer.valueOf(sub2);
                if (v < 9) {
                    v = v + 1;
                    sb.append("00").append(v);
                } else if (v >= 9 && v < 99) {
                    v = v + 1;
                    sb.append("0").append(v);
                } else {
                    v = v + 1;
                    sb.append(v);
                }
                result = sub1 + sb.toString();
                break;
            case 8:
                sub1 = code.substring(0, 5);
                sub2 = code.substring(5, length);
                v = Integer.valueOf(sub2);
                if (v < 9) {
                    v = v + 1;
                    sb.append("00").append(v);
                } else if (v >= 9 && v < 99) {
                    v = v + 1;
                    sb.append("0").append(v);
                } else {
                    v = v + 1;
                    sb.append(v);
                }
                result = sub1 + sb.toString();
                break;

            case 11:
                sub1 = code.substring(0, 8);
                sub2 = code.substring(8, length);
                v = Integer.valueOf(sub2);
                if (v < 9) {
                    v = v + 1;
                    sb.append("00").append(v);
                } else if (v >= 9 && v < 99) {
                    v = v + 1;
                    sb.append("0").append(v);
                } else {
                    v = v + 1;
                    sb.append(v);
                }
                result = sub1 + sb.toString();
                break;
            default:
                break;
        }
        return result;
    }
}
