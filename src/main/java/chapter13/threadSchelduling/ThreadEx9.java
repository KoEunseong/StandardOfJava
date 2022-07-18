package chapter13.threadSchelduling;

public class ThreadEx9 {
    public static void main(String[] args) {
        ThreadEx9_1 th1 = new ThreadEx9_1();
        ThreadEx9_2 th2 = new ThreadEx9_2();
        th1.start();
        th2.start();
        try {
            th1.sleep(2000);
        }catch (InterruptedException e){}

        System.out.println("main종료");
        

    }
}
class ThreadEx9_1 extends Thread{
    @Override
    public void run() {
        for(int i =0;i<300;i++){
            System.out.print("-");
        }
        System.out.print("th1종료");
    }

}

class ThreadEx9_2 extends Thread{
    @Override
    public void run() {
        for(int i =0;i<300;i++){
            System.out.print("|");
        }
        System.out.print("th2.종료");

    }

}