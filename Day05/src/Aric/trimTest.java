package Aric;

public class trimTest {

    public String Trim1(String str){

        //截取方法

        int start = 0;
        int end =str.length()-1 ;

//        1.先判断字符串是否以'\t'其实和结束,首字符为；空格

        while( start < end && str.charAt( start)== ' ' ){
            start++;
        }
        while( start < end && str .charAt( end) == ' '){
           end--;
        }
        if ( start == end){
            return "\t";
        }

        return str.substring(start,end+1);


    }



    public static void main(String[] args) {

        trimTest  t= new trimTest();
        String s1 = " ab c ";
        //将字符窜转化为数组



        String accept =t.Trim1(s1);
        System.out.println(accept);
    }
}

