package chapter14.lamda;

@FunctionalInterface
interface MyFunction{
    void run();
}

public class LamdaEx1 {
    static void aMethod(MyFunction f){
        f.run();
    }
    static MyFunction bMethod(){
        return ()->System.out.println("bMethod");
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        MyFunction f1 = ()->System.out.println("f1 ");
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() { //public 을 반드시 붙여야 함
                System.out.println("익명클래스로 구현한 f2");
            }
        };
        MyFunction f3 = bMethod();
        f1.run();
        f2.run();
        f3.run();
        f1 = f3;
        f1.run();
    }
}
