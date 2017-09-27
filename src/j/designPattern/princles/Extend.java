package j.designPattern.princles;

/**
 * Created by j on 2017/8/28.
 */
public class Extend {
    public static void main(String[] args) {

    }
}

class Parent {
    protected void method() {}
}

class Son extends Parent {
    @Override
    public void method() {}     // 方法访问权限放大，会破坏封装？
}
