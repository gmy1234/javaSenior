package Collection;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {

    @Test
    public  void test1(){

        Collection coll = new ArrayList();
        Collection coll2 =new ArrayList();
        Collection coll3 =new ArrayList();
        Collection coll4 =new ArrayList();


        coll.add("abc");
        coll.add(123);
        coll.add(456);
        coll.add(new String ( ));

        coll2.addAll(coll);
        coll.clear();
        System.out.println(coll2);

        Student s=new Student();
        coll.add(s);
        coll2.add(s);

        System.out.println(coll2.contains(s));// true
        coll4.add(1234);
        coll4.add(111);
        coll3.add(111);

//        判断集合coll3中的所以元素是否都存在coll4中
        System.out.println(coll4.containsAll(coll3));


    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(456);


        coll1.add("abc");
        coll1.add(123);
        coll1.add(456);

        //删
        System.out.println(coll.remove(123));
        System.out.println(coll);

        //差集
        coll.removeAll(coll1);
        System.out.println(coll);
        System.out.println(coll1);
        System.out.println("---------------------");
        //交集
        coll.retainAll(coll1);
        System.out.println(coll);
        System.out.println("---------------------");
        System.out.println(coll1);
        System.out.println(coll1.hashCode());

    }

    @Test
    public void test3(){
        Collection coll = new ArrayList();
        Collection coll1 = new ArrayList();

        coll.add("abc");
        coll.add(123);
        coll.add(456);


        coll1.add("abc");
        coll1.add(123);
        coll1.add(456);

        //集合----> 数组
        Object [] obj =coll.toArray();
//        增强循环
        for ( Object ob: coll){
            System.out.println(ob);
        }


        //数组----->集合：:调用Arrays类的静态方法asList()

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1

        List arr2= Arrays.asList(new Integer[]{1,2,3});
        System.out.println(arr2.size());


    }

}

class Student{

    int age;
    String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


}
