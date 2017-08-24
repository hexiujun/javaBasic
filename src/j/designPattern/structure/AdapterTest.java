package j.designPattern.structure;

/**
 * Created by j on 2017/6/12.
 *
 * 适配器模式：将类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所
 *          造成的类的兼容性问题。
 *
 * 三类：(a)类的适配器模式、(b)对象的适配器模式、(c)接口的适配器模式。
 *
 * (a)：有一个Source类，拥有一个方法，待适配，目标接口是Targetable，通过Adapter类，将
 *      Source的功能扩展到Targetable里。
 *
 * (b)：修改Adapter类，这次不继承Source类，而是持有Source类的实例，以达到兼容性目的。
 *
 * (c)：当需要实现一个接口的部分方法时，我们可以引入接口的适配器模式，借助一个抽象类实现该接口，
 *      再通过创建一个继承该抽象类的子类，重写我们需要的方法就行。
 */
public class AdapterTest {
    public static void main(String[] args) {
        // (a)
        Targetable target = new ClassAdapter();
        target.method();
        target.method2();

        // (b)
        Targetable target2 = new ObjectAdapter(new Source());
        target2.method();
        target2.method2();

        // (c)
        InterfaceAdapterSub target3 = new InterfaceAdapterSub();
        target3.method();
    }
}
