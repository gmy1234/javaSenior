package Aric;


/**
 * 获取两个字符串中最大相同子串。比如：
 * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
 * 提示：将短的那个串进行长度依次递减的子串与较长的串比较
 *
 * 前提：只有一个最大相同串
 */
public class MaxSameString {

    public static void main(String[] args) {

        MaxSameString a=new MaxSameString();

        String str1="abcwerthelloyuiodef";
        String str2="cvhellobnm";
        System.out.println(a.MaxSameStr(str1,str2));



    }

    public String MaxSameStr(String MaxString,String sonStr) {
        if (MaxString != null && sonStr != null) {

            for (int i = 0; i < MaxString.length(); i++) {

                for (int x = 0, y = sonStr.length() - i; y <= sonStr.length(); x++, y++) {
                    String subStr=sonStr.substring(x,y);

                    if (MaxString.contains(subStr)) {
                        return subStr;
                    }
                }

            }

        }
            return null;

    }

}
