package Aric;

/**
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
 * 转为”abfedcg”
 */
public class Myreverse {

    public static void main(String[] args) {

        String str ="abcdefg";

        Myreverse my=new Myreverse();
        System.out.println(my.reverse2(str,3,6));



    }

//    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反
// * 转为”abfedcg”
    public String myreverse(String str , int start,int end){
        if (str == null)
            return null;
        int left=start - 1;
        int right = end-1;

        char [] c =str.toCharArray();

        while ( left < right ){
            char temp=c[left];
            c[left]=c[right ];
            c[right ] = temp;

            left++;
            right --;
        }

        return new String(c);




    }

    //方式二
    public String reverse2(String str, int startIndex,int endIndex){
        StringBuilder builder=new StringBuilder(str.length());

        //1.拼接反转前的部分
        builder.append(str.substring(0,startIndex));

//        2.拼接反战的部分
        for ( int i = endIndex ; i >= startIndex ; i--){
            builder.append(str.charAt(i));
        }
//        拼接反转的后半部分
        builder.append(str.substring(endIndex+1));


        return builder.toString();

    }

}


