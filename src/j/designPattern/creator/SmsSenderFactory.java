package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 */
public class SmsSenderFactory implements Provider{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
