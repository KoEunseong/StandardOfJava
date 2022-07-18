package chapter14.stream;

import java.util.stream.IntStream;

public class FilterEx {
    public static void main(String[] args) {
        IntStream is1 = IntStream.of(1,1,3,3,5,5,7,7,7,1);
        IntStream is2 = IntStream.rangeClosed(1,10);

        is1.distinct().forEach(System.out::println);
        System.out.println("-----------------------------");
        is2.filter(i-> !(i % 3 == 0)).forEach(System.out::println);
    }
}
