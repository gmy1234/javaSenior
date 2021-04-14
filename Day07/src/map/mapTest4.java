package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
1 ）封装一个汽车类，包含String  name、int  speed属性，
    在测试类中实例化三个对象：c1，c2，c3，分别设置name为：“奥拓”，“宝马”，“奔驰”，
    速度分别设置为：100,200,300
2 ）使用Map集合对象m1将这三个汽车类对象保存成key，然后将int型的汽车价钱作为值保存在m1的value中，
    上述三款汽车分别对应的价钱是10000,500000,2000000
3 ）遍历m1的键，打印name属性

5 ）经过折旧，所有汽车都降价到原来的80%，请打印降价后“宝马”的价格
 */
public class mapTest4 {
    public static void main(String[] args) {
        Car c1=new Car("奥拓",100);
        Car c2=new Car("宝马",200);
        Car c3=new Car("奔驰",300);

        HashMap m1= new HashMap();
        m1.put(c1,10000);
        m1.put(c2,500000);
        m1.put(c3,2000000);

        Set set = m1.entrySet();
        Iterator iter = set.iterator();
        while( iter.hasNext()){
            Object obj = iter.next();
            Map.Entry entry = (Map.Entry) obj;


            Car cc=(Car)entry.getKey();
            Object bm = null;
            //        4 ）通过合适的方法，求出m1中“宝马”的价格，并打印结果；


           System.out.println(cc.getName());
                if( cc.getName() == "宝马") {
                System.out.print("价格为："+m1.get(c2));
        }
    }




    }

}

class Car{
    private String name;
    private  int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
