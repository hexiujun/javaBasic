package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 *
 * 线程安全单例构造
 *
 * 方法1：直接对 getInstance 方法加 synchronized 关键字。
 *
 * 方法2：方法1存在性能上的下降，因为每次调用 getInstance() 时都需要对对象上锁，
 *       事实上，只有在第一次创建对象时才需要加锁，这里采用 “双重锁” 的方法实现。
 *
 * 方法3（完美的单例模式）：方法2实际上依然存在问题，原因是：在Java指令中创建对象和
 *      赋值操作是分开进行的，但JVM并不能保证这两个操作的先后顺序。因此，可能的操作是先
 *      创建Singleton对象、再赋值给instance引用、再初始化Singleton实例，从而导致出错。
 *      以A、B两个线程为例：
 *          1）A 、B 线程同时进入第一个if判断
 *          2）A先进入synchronized块，执行 instance = new ThreadSafeSingleton();
 *          3）由于JVM内部优化机制，JVM分配给Singleton实例空白内存，并赋值给instance，然后
 *             A离开synchronize块（此时还未初始化该实例）。
 *          4）B进入synchronized块，马上离开并返回未被实例化的Singleton对象。
 *          5）当B使用Singleton实例时，错误发生。
 *     -->>
 *     解决方案：使用内部类来维护单例的实现。
 *     原理：JVM内部机制能保证当一个类被加载的时候，该加载过程是线程互斥的。
 *     @see PerfectSingleton 类, 完美的单利模式的构建。
 */
public class ThreadSafeSingleton {
    // 持有私有静态实例，防止被引用，赋值为null，目的是实现延迟加载
    private static ThreadSafeSingleton instance = null;

    // 构造方法私有，防止从外部实例化对象
    private ThreadSafeSingleton() {}

    // 线程安全的静态工厂方法创建实例，这里采用 “双重锁” 的方法实现
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized(instance) {
                if (instance == null)
                    instance = new ThreadSafeSingleton();
            }
        }

        return instance;
    }
}
