package Aric;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */
public class Mytimes {

    public static void main(String[] args) {

        Mytimes mytimes=new Mytimes();
        String str="abcdabcdab";
        System.out.println(mytimes.times(str,"ab"));


    }
    //int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    // int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出
    //现处的索引，从指定的索引开始
    public int times(String str,String flag) {

        int index=0;
        int count = 0;
        int strlength=str.length();
        int flaglength=flag.length();

        if ( str.length() < flag .length()){
            return 0;
        }else{

            //方式1
//            while( (index = str.indexOf(flag)) != -1){
//                count++;
//                str=str.substring(index+ flaglength);
//
//            }

//            方式二
            while((index = str.indexOf(flag,index))!=-1){
                count++;
                index += flag.length();
            }

            return count;
        }


    }


}
