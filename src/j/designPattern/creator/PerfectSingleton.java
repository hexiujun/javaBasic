package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 */
public class PerfectSingleton {
    private PerfectSingleton() {}

    private static class PefectSingletonFactory {
        private static PerfectSingleton instance = new PerfectSingleton();
    }

    public static PerfectSingleton getInstance() {
        return PefectSingletonFactory.instance;
    }
}
