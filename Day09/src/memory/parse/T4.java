package memory.parse;

import java.util.HashMap;
import java.util.Map;

public class T4 {
    public static void main(String[] args) {
        glaElem gl1 =new glaElem();
        gl1.setCode("aaa");

        Map<String , glaElem> glMap =new HashMap<>(2);
        glMap.put("aaa",gl1);

        glaElem gl2 =glMap.get("aaa");
        gl2.setCode("bbb");

        glMap.put("aaa",gl2);
        gl1.setCode("ccc");

        String s = glMap.get("aaa").getCode();
        System.out.println(s);


    }

}
class glaElem{
    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public glaElem(String code) {
        Code = code;
    }

    public glaElem() {
    }
}
