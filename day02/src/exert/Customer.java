package exert;

class Account {
    private double balance = 0;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void despot(double amt){

            if (amt > 0) {
                balance += amt;

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "存取成功，余额为" + balance);
            }

    }
}

public class Customer  implements Runnable{

    private Account acc;

    public Customer(Account acc){
        this.acc=acc;

    }

    @Override
    public void run() {



        for (int i = 0; i < 3; i++) {
                acc.despot(1000);
            }
        }



}


class AccountTest{
    public static void main(String[] args) {

        Account account=new Account(0);

        Customer customer1=new Customer(account);
        Customer customer2=new Customer(account);

        Thread c1=new Thread(customer1);
        Thread c2=new Thread(customer2);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();



    }


}
