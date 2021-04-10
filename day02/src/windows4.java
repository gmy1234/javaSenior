

public class windows4 implements Runnable{
    private int ticket =100 ;

    @Override
    public void run() {


            show();


    }

    public  synchronized void show() {

            while (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "买票 。票号为" + ticket);
                ticket--;
            }
        }
    }


class windowsTest4{
    public static void main(String[] args) {

         windows4 win=new windows4();

         Thread t1=new Thread(win);
         Thread t2=new Thread(win);
         Thread t3=new Thread(win);

         t1.setName("1号窗口");
         t2.setName("2号窗口");
         t3.setName("3号窗口");

         t1.start();
         t2.start();
         t3.start();

    }
}
