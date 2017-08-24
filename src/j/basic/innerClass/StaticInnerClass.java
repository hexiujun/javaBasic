package j.basic.innerClass;

/**
 * Created by j on 2017/8/18.
 */
public class StaticInnerClass {
    private static int a;
    private int b;

    private void method(){
        StaticInner.c = 1;

    }
    public void method2(){}

    class NotStaticInner {
        //static int a;
        //static void f(){}
        public void f2() {
            a = 1;
            b = 2;
        }
    }

    static class StaticInner {
        static int c;
        int d;

        public static void main(String[] args) {
            a = 1;
            //b = 2;
            new StaticInnerClass().method();

        }
    }
}
