package j.jvm.memory;

/**
 * Created by j on 2017/6/5.
 * VM args: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
           oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack Length: " + oom.stackLength);
            throw e;
        }
    }
}
