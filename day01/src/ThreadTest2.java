

public class ThreadTest2  implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            if(i % 2 == 0)
                System.out.println( Thread.currentThread().getName()+"--"+i);
        }
    }

}

class MyThread2{

    public static void main(String[] args) {

//        3.创建实现类的对象
        ThreadTest2 threadTest2=new ThreadTest2();
//        4.将实现类的对象传递到Thread的构造器当中
        Thread t2=new Thread(threadTest2);
        t2.start();

    }

}




