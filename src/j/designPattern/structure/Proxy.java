package j.designPattern.structure;

/**
 * Created by j on 2017/6/13.
 *
 * 代理模式：多一个代理类，替原对象进行一些操作。
 *
 * 应用场景：如果已有的方法在使用的时候需要对原有方法进行改进，就采用一个代理类调用原有的方法，
 *          且对产生的结果进行控制。
 *
 * 好处：功能划分更清晰，有助于后期维护！
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        super();
        source = new Source();
    }

    @Override
    public void method() {
        System.out.println("before proxy!");
        source.method();
        System.out.println("after proxy!");
    }
}
