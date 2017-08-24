package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 *
 * 工厂方法模式的一个问题：类的创建依赖工厂类，若要扩展程序，必须对工厂类进行修改，
 *                      这违背了闭包原则。
 *
 * 抽象工厂模式：将工厂抽象为一个接口，当需要增加新的功能时，直接增加一个实现该接口的工厂类。
 *
 * 优点：无需修改现有类，扩展性好。
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        Provider provider = new MailSenderFactory();

        Sender sender = provider.produce();
        sender.send();
    }
}

