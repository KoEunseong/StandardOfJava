package chapter14.lamda;

import java.util.function.*;

public class LamdaEx4 {
    public static void main(String[] args) {
        IntSupplier s = ()->(int)(Math.random()* 100)+ 1;
        IntConsumer c = i -> System.out.println(i);
        IntPredicate p = i -> i % 2 == 0;
        int[] arr = new int[100];
        makeRandomList(s,arr);

        for(int i: arr){
            if(check(p,i))
                c.accept(i);
        }

    }
    static void makeRandomList(IntSupplier s,int[] arr){
        for(int i = 0;i<arr.length;i++){
            arr[i] = s.getAsInt();
        }
    }
    static boolean check(IntPredicate p,int i){
        if(p.test(i))
            return true;
        else
            return false;
    }
}
