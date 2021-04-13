package Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class ArrayListTest {

    @Test
    public void test1(){

        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("gmy");
        list.add(new Person(31,"jack"));

        System.out.println(list);
        //接口方法
//        void add(int index, Object ele):在index位置插入ele元素

        list.add(2,"gg");
        System.out.println(list);

//        Object get(int index):获取指定index位置的元素
        System.out.println(list.get(4));

        System.out.println("____________---------------___________");
//      Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(2));
        System.out.println(list);


//      Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(2,"gmg");
        System.out.println(list);

//      List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
//                    左闭右开
        System.out.println(list.subList(1, 2));

        System.out.println("-----------------------------___________");

        //加个遍历
        Iterator iterator= list.iterator();

        while( iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



}

class Person{
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
