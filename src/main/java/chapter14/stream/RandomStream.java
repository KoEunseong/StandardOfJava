package chapter14.stream;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomStream {
    public static void main(String[] args) {
        IntStream intStream = new Random().ints(5,5,10);
        intStream.forEach(System.out::println);
    }
}
