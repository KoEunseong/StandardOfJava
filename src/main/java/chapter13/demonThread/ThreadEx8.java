package chapter13.demonThread;

public class ThreadEx8 implements Runnable{
    static boolean autoSave = false;
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadEx8());
        t.setDaemon(true); //쓰레드를 데몬 쓰레드로 변경한다. 데몬쓰레드로 설정안하면 프로그램이 종료되지 않음.
        t.start();

        for(int i = 1;i<=10;i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            System.out.println(i);

            if(i == 5)
                autoSave = true;
        }

        System.out.println("프로그램 종료");

    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(3000);
            } catch (Exception e) {}
            if(autoSave)
                autoSave();
        }
    }
    public void autoSave(){
        System.out.println("자동저장이래요");
    }
}

