package Annotation;

class Value{
    int i = 15;
}
class Test{
    public static void main(String argv[]) {
        Test t = new Test();
        t.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        System.out.println(v);

        //局部方法new的对象，在调用完方法后（方法结束后），对象出栈，生命周期结束
        second(v, i);
        System.out.println(v);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        System.out.println(v);
        Value val = new Value();
        System.out.println(val);
        v = val;
        System.out.println(v);
        System.out.println(v.i + " " + i);
    }
}