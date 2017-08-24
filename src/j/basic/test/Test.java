package j.basic.test;

/**
 * Created by j on 2017/6/16.
 */
public class Test {
    public static void main(String[] args) {
        //A.print();
        //B.print();

        A a = new B();
        a.print();
    }
}

class A {
    static void print() {
        System.out.println("A");
    }
}

class B extends A {
    static void print() {
        System.out.println("B");
    }
}
