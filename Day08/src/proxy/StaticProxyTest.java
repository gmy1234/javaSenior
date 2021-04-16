package proxy;

/*
 * 静态代理的举例：
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 */
interface ClothFactor{
    //方法：生产衣服
    void produceCloth();
}

//代理类
class proxyClothFactor implements ClothFactor{

    //作为被代理类的实例化对象
    private ClothFactor clothFactor;

    public proxyClothFactor(ClothFactor clothFactor) {
        this.clothFactor = clothFactor;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做准备工作");

        clothFactor.produceCloth();

        System.out.println("代理工程做收尾工作");
    }
}

//被代理类
class LiNingClothFactor implements ClothFactor{
    @Override
    public void produceCloth() {
        System.out.println("LiNing工程生产一批运动服装");
    }
}



public class StaticProxyTest {
    public static void main(String[] args) {

//      创建被代理类的对象
        LiNingClothFactor LiNing = new LiNingClothFactor();
//      创建代理类对象
        proxyClothFactor proxyCF = new proxyClothFactor(LiNing);

        proxyCF.produceCloth();

    }
}
