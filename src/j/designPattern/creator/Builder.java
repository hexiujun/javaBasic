package j.designPattern.creator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 2017/6/12.
 *
 * 建造者模式：创建逻辑上同属于同一对象（父类或接口）的不同
 *            实例对象（同一父类的不同子类或同一接口的不同实现）。
 */
public class Builder {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count) {
        while (count-- > 0)
            list.add(new MailSender());
    }

    public void produceSmsSender(int count) {
        while (count-- > 0)
            list.add(new SmsSender());
    }
}
