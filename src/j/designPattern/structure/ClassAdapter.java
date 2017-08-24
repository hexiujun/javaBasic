package j.designPattern.structure;

/**
 * Created by j on 2017/6/12.
 *
 * 类的适配器模式的实现
 */

public class ClassAdapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}