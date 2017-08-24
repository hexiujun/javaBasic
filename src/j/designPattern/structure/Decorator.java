package j.designPattern.structure;

/**
 * Created by j on 2017/6/13.
 *
 * 装饰器模式：给一个对象动态地增加一些新的功能，要求装饰对象和被装饰对象实现同一个接口，
 *           装饰对象持有被装饰对象的实例。
 *
 * 应用场景：
 *      （1）需要扩展一个类的功能。
 *      （2）动态为一个对象增加功能，而且能动态撤销。（继承不行）？？不太理解。。。
 * 缺点：产生过多相似的对象，不易排错！
 */
public class Decorator implements Sourceable {
    private Sourceable source;

    public Decorator(Sourceable source) {
        super();
        this.source = source;
    }

    @Override
    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }

    public static void main(String[] args) {
        Sourceable source = new Source();

        Sourceable objective = new Decorator(source);

        objective.method();
    }
}
