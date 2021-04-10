/**
 * 买票窗口,三个窗口,三个线程
 * 共100张票
 */

//用继承Thread的方式创建
public class windows extends Thread{
    private static int ticket=100;

    @Override
    public void run() {


            while (ticket > 0) {
                synchronized (new Object()) {
                System.out.println(getName() + "票号 :" + ticket);
                ticket--;
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
        win1.start();

        win2.setName("二号窗口");
        win2.start();

        win3.setName("三号窗口");
        win3.start();
    }
}
