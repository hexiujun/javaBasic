package j.jvm.earlyCompileOpt;

/**
 * Created by j on 2017/7/18.
 */
public class BinTrack {
    public static void main(String[] args) {
        Integer a = 1, b = 2, c = 3, d = 3, e = 321, f = 321;
        int a1 = 1, e1 = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(a == a1);
        System.out.println(e == e1);
    }
}
