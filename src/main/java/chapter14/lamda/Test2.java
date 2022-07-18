package chapter14.lamda;

import java.util.ArrayList;
public class Test2 {

    public static void main(String[] args) {
        @Deprecated
        Integer i = 5;
        @SuppressWarnings("unchecked")
        ArrayList arr = new ArrayList();
        arr.add(i);
    }
}
