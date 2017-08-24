package j.jvm.classload;

/**
 * Created by j on 2017/7/12.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
