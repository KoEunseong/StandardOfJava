package chapter14.lamda;
@FunctionalInterface
interface Myf{
    void myM();
}
class Outer{
    int val = 10;

    class Inner {
        int val = 20;

        void method(int i){
            int val = 30;
            //i = 10;

            Myf f = () -> {
                System.out.println(i);
                System.out.println(val); //30
                System.out.println(this.val); //20
                System.out.println(Outer.this.val); //10
            };
            f.myM();
        }
    }
}


public class lamdaEx2 {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner inner = o.new Inner();
        inner.method(100);
    }
}
