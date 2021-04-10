/**
 * 买票窗口,三个窗口,三个线程
 * 共100张票
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 */

//用继承Thread的方式创建
public class windows extends Thread{
    private static int ticket=100;

    private static Object obj=new Object();

    @Override
    public void run() {


            while (true) {
                synchronized ( obj ) {
                    if(ticket > 0){

                        try {
                           Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println(getName() + "票号 :" + ticket);
                        ticket--;
                    }else
                        break;
            }
        }
    }
}

//目前这样会出现重票，票号不对 的情况， 用同步机制来解决
//1.   synchronized(同步监视器（锁）)  即 同步代码块
class WindowsTest1{

    public static void main(String[] args) {

        windows win1=new windows();
        windows win2=new windows();
        windows win3=new windows();

        win1.setName("一号窗口");
        win2.setName("二号窗口");
        win3.setName("三号窗口");


        win1.start();
        win2.start();
        win3.start();
    }
}
