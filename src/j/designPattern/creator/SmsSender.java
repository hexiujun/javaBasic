package j.designPattern.creator;

/**
 * Created by j on 2017/6/8.
 */
public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("This is smssender!");
    }
}
