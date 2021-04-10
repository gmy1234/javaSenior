package exert;

/*
 * 生产者(Product)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 */


class Clerk{
    private int count= 0 ;

    private Clerk clerk;

    //生产
    public synchronized void pro() {
        notify();
        if ( count < 20){
            count++;
            System.out.println(Thread.currentThread().getName()+"生产:"+count);


        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    消费
    public synchronized void con() {

        if ( count > 0){

            notify();

            System.out.println(Thread.currentThread().getName()+"消费"+count);
            count--;
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Product extends Thread{
    private Clerk clerk;

   public Product(Clerk clerk){
       this.clerk= clerk;
   }


    @Override
    public void run() {
        System.out.println(getName()+"开始生产");

        while (true){

            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.pro();
        }

    }
}

class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk=clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+"开始消费");

        while (true){

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.con();
        }
    }
}


public class ConsumerTest {

    public static void main(String[] args) {
        Clerk clerk=new Clerk();


        Product p=new Product(clerk);
        Consumer c=new Consumer(clerk);

        p.setName("生产者");
        c.setName("消费者");

        p.start();
        c.start();

    }

}
