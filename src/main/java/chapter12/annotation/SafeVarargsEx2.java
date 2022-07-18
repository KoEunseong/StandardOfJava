package chapter12.annotation;

import java.util.Arrays;

class MyList<T>{
    T[] arr;

    MyList(T... arr)
    {
        this.arr = arr;
    }
    public static <T> MyList<T> asList(T... a){
        return new MyList<>(a);
    }
    public String toString(){
        return Arrays.toString(arr);
    }
}

public class SafeVarargsEx2 {

    public static void main(String[] args) {
        MyList<String> list = MyList.asList("1","2","3");
        System.out.println(list);
    }
}
