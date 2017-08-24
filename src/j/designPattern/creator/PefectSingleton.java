package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 */
public class PefectSingleton {
    private PefectSingleton() {}

    private static class PefectSingletonFactory {
        private static PefectSingleton instance = new PefectSingleton();
    }

    public static PefectSingleton getInstance() {
        return PefectSingletonFactory.instance;
    }
}
