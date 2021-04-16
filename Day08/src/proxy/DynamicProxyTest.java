package proxy;
import java.lang.reflect.*;

interface Human{
    String getBelief();

    void eat( String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return " I believe I can success";
    }

    @Override
    public void eat(String food) {

        System.out.println("我喜欢吃"+food);
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */

class proxyFactor{

    //调用此方法，返回一个代理对象
    public static Object getProxyInstance(Object obj){//obj被代理对象


        MyInvocationHandler handler =new MyInvocationHandler();
        handler.bi(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),handler);


    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object object;  //需要使用被代理类的对象经行赋值

    public void bi(Object object){
        this.object=object;
    }
    //当我们通过代理类，调用方法a时，就会自动调用如下方法：invoke（）；
//    将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //method：代理类对象调用的方法，此方法也是被代理类对象要调用的方法
//        obj：被代理的对象
        Object returnValue = method.invoke(object,args);
//        上述方法的返回值就作为当前类中invoke（）的返回值
        return returnValue;

    }
}

public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
//        proxyInstance:代理类的对象
        Human proxyInstance = (Human) proxyFactor.getProxyInstance(superMan);

        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("麻辣烫");

    }

}
