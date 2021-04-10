
public class ThreadTest extends Thread {

    //遍历108以内的偶数
    @Override
    public void run() {
        for(int i= 0 ; i < 109 ; i ++){
            if(i %2 == 0){
                System.out.println(i);
            }
        }
    }




}

class MyThread{
    public static void main(String[] args) {
        ThreadTest test=new ThreadTest();
        test.start();


        for(int i= 0 ; i < 109 ; i ++){
            if(i %2== 0){
                System.out.println(i+"______main()_____");
            }
        }
    }

}
