package chapter11;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push("고은성");
        ms.push(1);
        ms.push(2);

        while(!ms.empty()){
            System.out.println(ms.pop());
        }

    }
}
