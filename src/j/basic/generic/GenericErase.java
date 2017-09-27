package j.basic.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by j on 2017/9/12.
 */
public class GenericErase {
    public static void main(String[] args) {
        Object[] array = new String[2];
        array[0] = "ab";
        //array[1] = 1;     // java.lang.ArrayStoreException

        Object[] array1 = new List[2];
        array1[0] = new ArrayList<Integer>();
        array1[1] = new LinkedList<String>();
        // error can not find

        Class a = new ArrayList<Integer>().getClass();
        Class b = new ArrayList<String>().getClass();
        System.out.println(a == b); // true
    }

    public static <T> void append(List<T> list, Class<T> tClass) throws Exception{
        //T element1 = new T();     // not allowed

        // solve it by using reflection
        T element = tClass.newInstance();
        list.add(element);
    }
}
