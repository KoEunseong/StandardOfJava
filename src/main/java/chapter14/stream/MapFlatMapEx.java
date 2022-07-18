package chapter14.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class MapFlatMapEx {
    public static void main(String[] args) {
        Stream<String[]> strArrstrm = Stream.of( new String[]{"abc","cde","efg"},new String[]{"ABC","123","DDD"} );
        Stream<String> newStream = strArrstrm.flatMap(Arrays::stream);
        newStream.map(String::toUpperCase).distinct().sorted()
                 .forEach(System.out::println);

        System.out.println();

        String[] lines = new String[]{
                "SHOW ME THE MONEY",
                "POWER OVERWHELMING",
                "FOOD FOR THOUGHT"
        };
        Stream<String> lineStream = Stream.of(lines);
        Stream<String> words = lineStream.flatMap(line ->Stream.of(line.split(" +")));
        words.forEach(System.out::println);

        System.out.println();

        Stream<String> strStrm = Stream.of("abc","cde","efg");
        Stream<String> strStrm2 = Stream.of("fff","ggg","hhh");
        Stream<Stream<String>> strmStrm = Stream.of(strStrm,strStrm2);

        Stream<String> stringStream = strmStrm
                .map(s->s.toArray(String[]::new)) //Stream<Stream<String>>->Stream<String[]>
                .flatMap(Arrays::stream); //Stream<String[]> ->Stream<String>

        stringStream.sorted().distinct().forEach(System.out::println);




    }
}
