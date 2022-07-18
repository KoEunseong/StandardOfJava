package chapter14.stream;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        IntStream charStream = "12345".chars();
        int charSum = charStream.map(ch->ch-'0').sum();
        System.out.println(charSum);

    }
}
