package practice;

public class TestClass {
    public static void main(String[] args) throws InterruptedException {
        String s = "Show me     the money";
        String[] sArr = s.split(" +");
        for(String a : sArr){
            System.out.println(a);
            System.out.println(a.length());

            Thread.sleep(500);



        }
    }
}
