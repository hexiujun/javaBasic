package j.designPattern.structure;

/**
 * Created by j on 2017/6/13.
 *
 * 对象的适配器模式的实现
 */
public class ObjectAdapter implements Targetable {
    private Source source;

    public ObjectAdapter(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }

    @Override
    public void method() {
        source.method();
    }
}
