package chapter_3.com.flexible;

import org.junit.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2019-01-15
 * Time: 8:24
 */
public class Demo {


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(100);
        TimeUnit.HOURS.sleep(5);
        TimeUnit.MINUTES.sleep(30);
        TimeUnit.SECONDS.sleep(25);
        TimeUnit.MILLISECONDS.sleep(100);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t1.setPriority(6);
    }

    @Test
    public void testMethod(){
        String path = "E:\\data\\7b0ffecf-48ff-4bee-ac25-a64edcd9bd0d1085361531660533760.xlsx";
        zipUtil(path,"E:\\data\\demo.zip");


    }
    public static void zipUtil(String filePath, String outPath){
        //输入
        File file = null;
        FileInputStream fis = null;
        BufferedInputStream bin = null;
        DataInputStream dis = null;
        //输出
        File outfile = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ZipOutputStream zos = null;
        ZipEntry ze = null;
        try {
            //输入-获取数据
            file = new File(filePath);
            fis = new FileInputStream(file);
            bin = new BufferedInputStream(fis);
            dis = new DataInputStream(bin); //增强
            //输出-写出数据
            outfile = new File(outPath);
            fos = new FileOutputStream(outfile);
            bos = new BufferedOutputStream(fos, 1024); //the buffer size
            zos = new ZipOutputStream(bos); //压缩输出流
            ze = new ZipEntry(file.getName()); //实体ZipEntry保存
            zos.putNextEntry(ze);
            int len = 0;//临时文件
            byte[] bts = new byte[1024]; //读取缓冲
            while((len=dis.read(bts)) != -1){ //每次读取1024个字节
                System.out.println(len);
                zos.write(bts, 0, len); //每次写len长度数据，最后前一次都是1024，最后一次len长度
            }
            System.out.println("压缩成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try { //先实例化后关闭
                zos.closeEntry();
                zos.close();
                bos.close();
                fos.close();
                dis.close();
                bin.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
