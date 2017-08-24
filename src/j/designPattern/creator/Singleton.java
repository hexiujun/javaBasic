package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 *
 * 非线程安全的单例构造
 */
public class Singleton {
    // 持有私有静态实例，防止被引用，赋值为null，目的是实现延迟加载
    private static Singleton instance = null;

    // 构造方法私有，防止从外部实例化对象
    private Singleton() {}

    // 静态工厂方法，创建实例
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();

        return instance;
    }

}
