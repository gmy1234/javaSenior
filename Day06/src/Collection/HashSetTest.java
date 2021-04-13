package Collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetTest    {


    @Test
    public void test1(){

        HashSet hashSet=new HashSet();

        hashSet.add("gmy");
        hashSet.add(123);
        hashSet.add(435);
        hashSet.add(new Person(3,"jerry"));
        hashSet.add(new Person(3,"jerry"));

        System.out.println(hashSet);

    }

    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(213);
        set.add(21);
        set.add(13);
        set.add(new Person(21,"香香"));

        System.out.println(set);

    }



}



