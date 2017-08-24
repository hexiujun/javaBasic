package j.basic.test;

/**
 * Created by j on 2017/8/19.
 */
public class Something implements Cloneable{
    public int a;

    public Something() {}   // support for Class.newInstance();

    public Something(int a) {
        this.a = a;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}