public class windows2 implements Runnable{
    private  int ticket = 100;
    @Override
    public void run() {
        while(ticket > 0){
            System.out.println(Thread.currentThread().getName()+"--票号为："+ticket);
            ticket--;
        }

    }
}

class windowsTest2{
    public static void main(String[] args) {

        windows2 win2=new windows2();

        Thread t1=new Thread(win2);
        Thread t2=new Thread(win2);
        Thread t3=new Thread(win2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
