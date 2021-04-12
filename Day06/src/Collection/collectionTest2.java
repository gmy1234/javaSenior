package Collection;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Iterator  迭代器
public class collectionTest2 {

    @Test
    public void test1(){
        Collection coll1 =new ArrayList();
        coll1.add(123);
        coll1.add("gmy");
        coll1.add(892);

        Iterator iterator=coll1.iterator();


        //遍历集合的元素
        while ( iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //hasNext()判断集合的下一个地址还有元素
        //next() 1.指针向下移动一个地址，2将下移的元素返回

    }
    @Test
    public void test3(){
        Collection coll =new ArrayList();
        coll.add(123);
        coll.add("gmy");
        coll.add(892);

        Iterator iterator=coll.iterator();

        //遍历方式2：
        for(Object obj: coll ){
            System.out.println(obj);
        }

        int [] arr=new int[]{1,2,3};
        for( int i :arr){
            System.out.println(i);
        }

    }


}
