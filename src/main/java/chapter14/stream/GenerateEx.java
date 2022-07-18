package chapter14.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateEx {
    public static void main(String[] args) {

        Stream<Integer> randomStream = Stream.generate(()->(int)(Math.random()*6) +1 );
        randomStream.limit(10).forEach(System.out::println);

        IntStream evenStream = Stream.iterate(0,n->n+2).mapToInt(Integer::intValue);
        Stream<Integer> stream = evenStream.boxed(); // IntStream->Stream<Integer>



    }
}
