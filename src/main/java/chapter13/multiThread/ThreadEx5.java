package chapter13.multiThread;

import javax.swing.*;

public class ThreadEx5 {
    public static void main(String[] args) {
        ThreadMultiEx th1 = new ThreadMultiEx();
        th1.start();

        String input = JOptionPane.showInputDialog("아무값이나 ㅎㅎ");
        System.out.println("input = " + input);
    }
}
class ThreadMultiEx extends Thread{
    @Override
    public void run() {
        for(int i = 0; i< 10; i++){
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e) {
            }
        }

    }
}
