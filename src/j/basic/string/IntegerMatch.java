package j.basic.string;

/**
 * Created by j on 2017/6/7.
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+6789".matches("(-|\\+)?\\d+")); // java 中，"\\" 表示我要插入一个正则表达式的反斜杠，
                                                              // 所以后面的字符具有特殊的意义，"\n\t"例外。
        System.out.println("(1234)".matches("\\(\\d+\\)"));
    }
}
