package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
使用Map接口的实现类完成员工工资(姓名--工资)的摸拟：
1)添加几条信息
2)列出所有的员工姓名
3列出所有员工姓名及其工资
4)删除名叫“Tom”的员工信息
5)输出Jack的工资，并将其工资加1000元(通过取值实现)

 */
public class mapTest2 {

    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("张三",5000);
        map.put("李四",10000);
        map.put("王五",8000);
        map.put("马云",15000);
        map.put("JOM0",7000);


        map.remove("JOM0");
        int a= (int) map.get("马云")+ 1000;
        System.out.println(a);



//        6)将所有工资低于10000元的员工的工资上涨20%(通过取值实现)
        Set set1 = map.entrySet();

        Iterator iter= set1.iterator();
        while ( iter.hasNext()){
            Object obj2 = iter.next();
            Map.Entry m=( Map.Entry) obj2;

            if( ( int )m.getValue() < 10000){
               m.setValue( (int )m.getValue()* 1.2);
            }

        }
        System.out.println(map);





//        改变map中的key——value（键值对）其中的一个：

//        1、entrySet()转成set，
//        2构造迭代器，
//        3将迭代器中的内容赋值给Object，
//        4将Object转成Entry，5判断是否增加


        //set里存的是key——value键值对集合
        Set set= map.entrySet();
//        用于遍历
        Iterator iterator= set.iterator();


        while( iterator.hasNext()){

            Object obj1= iterator.next();       // 将返回的元素付给Obj中 。
            Map.Entry entry=(Map.Entry)  obj1;      //将Object转成Entry，
            if( (int )entry.getValue() < 10000){
                map.put( ( String )entry.getKey(),( int ) entry.getValue()* 1.2);
            }
        }
        System.out.println(map);
    }

}
class Person{

    private String name;
    private int slaray;

    public Person(String name, int slaray) {
        this.name = name;
        this.slaray = slaray;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", slaray=" + slaray +
                '}';
    }
}
