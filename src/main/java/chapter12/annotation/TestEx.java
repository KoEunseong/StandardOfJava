package chapter12.annotation;

//import org.testng.annotations.Test;

class Parent {
    @Deprecated
    int a;
    void parentMethod() { }
}

class Child1 extends Parent {
    @Override
    void parentMethod() { } // 조상 메서드의 이름을 잘못적었음.
}

public class TestEx {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Parent p = new Child1();
        p.a = 5;
        System.out.println(p.a);
        System.out.println(p.a);

    }
}
