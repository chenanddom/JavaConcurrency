package chapter_10.com.flexible;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * Description:字定义类加载器(这里必须是ClassLoader的直接或者间接子类)
 * User: chendom
 * Date: 2019-01-24
 * Time: 9:09
 */
public class MyClassLoader extends ClassLoader {

    //自定义默认的class存放的路径
    private final static Path DEFAULT_CLASS_DIR = Paths.get("F://classloader1");

    private final Path clasDir;

    //使用默认的class路径
    public MyClassLoader(){
        super();
        this.clasDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(Path clasDir) {
        this.clasDir = clasDir;
    }

    public MyClassLoader(ClassLoader parent, Path clasDir) {
        super(parent);
        this.clasDir = clasDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //读取class的二进制数据
        byte[] classBytes = this.readClassBytes(name);
        //如果数据为null，或者没有读到任何信息，则抛出ClassNotFoundException异常


        return super.findClass(name);
    }
    //将classwenji按读入内存
    private byte[] readClassBytes(String names) throws ClassNotFoundException {
        //将报名分割符专管未文件路劲分隔符
        String classPath = names.replace(".","/");
        Path classFullPath = clasDir.resolve(Paths.get(classPath+".class"));
        if (!classFullPath.toFile().exists()){
            throw  new ClassNotFoundException("The class "+names+" not found");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath,baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw  new ClassNotFoundException("The class "+names+" occur error.",e);
        }
    }

    @Override
    public String toString() {
        return MyClassLoader.class.getName();
    }

    public static void main(String[] args) throws ClassNotFoundException{
        //声明一个MyClassLoader
        MyClassLoader classLoader = new MyClassLoader();
        //使用MyClassLoader加载Demo
        Class<?> aClass = classLoader.loadClass("HelloDemo");
        System.out.println(aClass.getClassLoader());
        //注释
        Object demo = null;
        try {
            demo = aClass.newInstance();
            System.out.println(demo);
            Method method = aClass.getMethod("showInfo");
            method.invoke(demo);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(demo);
    }
}
