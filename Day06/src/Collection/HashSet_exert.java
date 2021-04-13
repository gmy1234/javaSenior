package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSet_exert {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");
        set.add(p1);
        set.add(p2);

        p1.name = "CC";
        set.remove(p1);
        /*
         *set通过remove方法 去移除p1，remove方法通过新的hash值在set里去寻找此hash值的数据，
         * 此时p1的name改变了，因此p1的hash值改变了，所以移除失败
         */
        System.out.println(set);


        /*
        增加的新数据，set里没有相同的hash值，所以增加成功
         */
        set.add(new Person(1001,"CC"));
        System.out.println(set);

        /*
            增加的新数据，虽然有相同的hash值，但是equals的内容不同，因此增加成功
         */
        set.add(new Person(1001,"AA"));
        System.out.println(set);
    }

    @Test
    public void test2(){
//        在List内删除内容相同的数据
        List list=new ArrayList();

        HashSet set=new HashSet();

        set.addAll(list);

//        return new ArrayList(set);
    }
}
