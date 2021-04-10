/**
 * 买票窗口,三个窗口,三个线程
 * 共100张票

    解决线程的安全问题 方式二：
    同步方法 :将操作共享数据的代码写入到 一个方法当中，在run方法中调用此方法
    有监视器，但是不需要声明
    非静态的同步方法：锁是this
    静态的同步方法：锁是当前类的本身

 */
public class windows3 extends Thread{

    //      静态的
    private static int ticket=100;

    @Override
    public void run() {

            show();
    }

    //      静态的：
    private static synchronized void show() {


        while (ticket > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "票号 :" + ticket);
            ticket--;

        }
    }
}



class WindowsTest3{

    public static void main(String[] args) {

        windows3 win1 =new windows3();
        windows3 win2 =new windows3();
        windows3 win3 =new windows3();

        win1.setName("一号窗口");
        win2.setName("二号窗口");
        win3.setName("三号窗口");

        win1.start();
        win2.start();
        win3.start();
    }
}
