package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 */
public class Factory {
    // 普通工厂方法模式
    public Sender produce(String type) {
        if ("mail".equals(type))
            return new MailSender();
        else if ("sms".equals(type))
            return new SmsSender();
        else {
            System.out.println("Please input correct type!");
            return null;
        }
    }


    // 多个工厂方法模式
//    public Sender produceMail() {
//        return new MailSender();
//    }
//
//    public Sender produceSms() {
//        return new SmsSender();
//    }


    // 静态工厂方法模式
    public static Sender produceMail() {
        return new MailSender();
    }

    public static Sender produceSms() {
        return new SmsSender();
    }


}
