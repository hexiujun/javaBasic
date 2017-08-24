package j.basic.test;

/**
 * Created by j on 2017/6/25.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Something something = new Something(4);
        try {
            Something newthing = something.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

//class Something implements Cloneable{
//    public int a;
//
//    public Something(int a) {
//        this.a = a;
//    }
//
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
//}
