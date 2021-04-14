package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
使用HashMap类实例化一个Map类型的对象m1，键（String类型）和值（int型）
分别用于存储员工的姓名和工资，存入数据如下：
张三——800元；李四——1500元；王五——3000元；



4）遍历集合中所有的工资
 */
public class mapTest3 {
    public static void main(String[] args) {
        HashMap m1=new HashMap(8);
        m1.put("张三",800);
        m1.put("李四",1500);
        m1.put("王五",3000);

//        1）将张三的工资更改为2600元  : 再次放入一个值，会覆盖
        m1.put("张三",2600);


        System.out.println(m1);



//        2）为所有员工工资加薪100元；遍历集合中所有的工资
        Set set = m1.entrySet();
        Iterator iterator = set.iterator();

        while( iterator .hasNext()){

            Object o2=iterator.next();
            Map.Entry entry=(Map.Entry) o2;

            entry.setValue((int)entry.getValue()+100);
            System.out.println(entry.getValue());

        }

//        3）遍历集合中所有的员工
        Set set2=m1.entrySet();

        Iterator iter2=set2.iterator();
        while( iter2.hasNext()){
            Object o2=iter2.next();
            Map.Entry entry2= (Map.Entry) o2;

            System.out.println(entry2.getKey());

        }



    }

}
