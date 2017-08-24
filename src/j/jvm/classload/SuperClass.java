package j.jvm.classload;

/**
 * Created by j on 2017/7/12.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 9999;
    public static final String HELLOWORLD = "hello world!";
}
