package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 *
 * 工厂模式：就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。
 *
 * 适用场景：出现了大量的产品需要创建，并且具有共同的接口时。
 *
 * 大多数情况，选择第三种 —— 静态工厂方法模式。
 */
public class FactoryTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Sender sender = factory.produce("sms");
        sender.send();

        //Sender sender2 = factory.produceMail();
        Sender sender2 = Factory.produceMail();
        sender2.send();
    }
}

