package chapter13.priority;

public class ThreadEx6 {
    public static void main(String[] args) {
        /*
        우선순위는 숫자가 높을수록 높고, 쓰레드의 우선순위는 쓰레드를 생성한 쓰레드로부터 상속받는다.
        ex) main메서드를 수행하는 쓰레드는 우선순위가 5이므로 main메서드내에서 생성하는 쓰레드의 우선순위는 자동적으로 5가된다.
        */
        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

        th2.setPriority(10);
        System.out.println("th1(-) = " + th1.getPriority());
        System.out.println("th2(|) = " + th2.getPriority());
        th1.start();
        th2.start();


    }
}
class ThreadEx6_1 extends Thread{
    @Override
    public void run() {
        for(int i =0;i<300;i++){
            System.out.print("-");
            for(int x = 0;x<10000000;x++);
        }
    }
}

class ThreadEx6_2 extends Thread{
    @Override
    public void run() {
        for(int i =0;i<300;i++){
            System.out.print("|");
            for(int x = 0;x<10000000;x++);
        }
    }
}