package j.basic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by j on 2017/8/27.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("j.basic.ReflectClass");
        Class c2 = ReflectClass.class;
        ReflectClass obj = new ReflectClass();
        Class c3 = obj.getClass();


        Field fstr = c1.getDeclaredField("string");
        fstr.setAccessible(true);
        Object o = c1.newInstance();
        fstr.set(o, "string changed");
        System.out.println(fstr.get(o));
        System.out.println(Modifier.toString(fstr.getModifiers()));

        Field fi = c1.getDeclaredField("i");
        //System.out.println(fi.get(c1)); // IllegalAccessException
        fi.setAccessible(true);
        System.out.println(fi.get(c1));

        Field[] fs = c1.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append(Modifier.toString(c1.getModifiers()) + " class " + c1.getSimpleName() + "{\n");
        for (Field field : fs) {
            sb.append("\t");
            sb.append(Modifier.toString(field.getModifiers()) + " ");
            sb.append(field.getType().getSimpleName() + " ");
            sb.append(field.getName() + ";\n");
        }
        sb.append("}");
        System.out.println(sb);


    }
}

class ReflectClass {
    private static int i = 0;
    public static int i1 = 1;
    private String string = "string";
    public String string1 = "string1";

    public ReflectClass() {}

    private void method() {
        System.out.println(string);
    }

    private static void method1() {
        System.out.println(i);
    }
}
