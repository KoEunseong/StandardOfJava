package practice;
interface Inter{
    void aMethod();
}
public class TestClass2 {
    static public Inter getInter(){
        Inter i = new Inter() {
            @Override
            public void aMethod() {
                        System.out.println("a");
                }
            };
        return i;
    }
    public static void main(String[] args) {
        Inter i = getInter();
        i.aMethod();
    }
}
