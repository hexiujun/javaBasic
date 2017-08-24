package j.designPattern.creator;

/**
 * Created by j on 2017/6/12.
 *
 * 原型模式：将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 *
 * 实现：复制对象是通过clone()实现的
 */
public class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();

        return proto;
    }
}
