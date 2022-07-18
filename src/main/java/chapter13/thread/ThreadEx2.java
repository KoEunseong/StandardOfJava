package chapter13.thread;

public class ThreadEx2 {
    public static void main(String[] args) {
        Thread t1 = new ThreadMake2_1();
        t1.start();
    }
}
class ThreadMake2_1 extends Thread{
    @Override
    public void run() {
        throwException();
    }
    public void throwException(){
        try {
            throw new Exception();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}