/*
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 */


import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

class Clerk{

    int procount=0;

    //生产
    public synchronized void product() {

        if( procount < 20){
            procount++;
            System.out.println(currentThread().getName()+"生产:"+procount+"产品");


            notify();

        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    //消费
    public synchronized void consume() {

        if( procount > 0){

            System.out.println(currentThread().getName()+"消费产品："+procount);
            procount--;

            notify();
        }else{

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        //生产

        System.out.println(Thread.currentThread().getName()+"开始生产");

        while(true) {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.product();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }


    @Override
    //消费
    public void run() {

        System.out.println(Thread.currentThread().getName()+"开始消费");

            while(true) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            clerk.consume();
            }


        }
    }




public class producerTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();


        Consumer consumer=new Consumer(clerk);
        Producer producer=new Producer(clerk);

        Thread c1=new Thread(consumer);
        Thread c2=new Thread(consumer);

        Thread p=new Thread(producer);
        Thread p2=new Thread(producer);

        c1.setName("消费者1");
        c2.setName("消费者2");
        p.setName("生产者");
        p2.setName("生产者2");

        p.start();
        c1.start();



    }
    
}
