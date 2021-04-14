package CollTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
1.生成10个随机数，值在100到200之间；
2.将这十个数存入HashSet集合中（有可能集合的长度小于10）。
3.将这个HashSet集合转换成ArrayList集合
4.重新为ArrayList集合排序，按照从小到大的顺序；
5.使用foreach遍历集合；
 */
public class ListTest6 {

    public static void main(String[] args) {

        HashSet hashSet=new HashSet();
        ArrayList arrayList =new ArrayList();

        for(int i =0 ; i < 10 ; i ++){
            hashSet.add((int)(Math.random()*100+ 100+1));
        }
        System.out.println(hashSet);

        arrayList.addAll(hashSet);

//        4.重新为ArrayList集合排序，按照从小到大的顺序；
        Collections.sort( arrayList);



//        5.使用foreach遍历集合；
        for (Object o1: arrayList) {
            System.out.println(o1);

        }


    }
}
