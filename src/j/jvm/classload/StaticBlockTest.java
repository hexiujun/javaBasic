package j.jvm.classload;

/**
 * Created by j on 2017/7/13.
 */
public class StaticBlockTest {
    static {
        i = 0;  // 给变量赋值可正常编译通过
//        System.out.println(i);    // “非法向前引用” 错误
    }
    static int i = 1;
}
