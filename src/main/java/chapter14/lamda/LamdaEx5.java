package chapter14.lamda;

import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaEx5 {
    public static void main(String[] args) {
        Function<String,Integer> f = s -> Integer.parseInt(s,16);
        Function<Integer,String> g = i -> Integer.toBinaryString(i);

        Function<String,String> h = f.andThen(g);
        Function<Integer,Integer> j = f.compose(g);
        System.out.println(h.apply("FF"));
        System.out.println(j.apply(2));

        Predicate<Integer> p = i -> i > 100;
        Predicate<Integer> q = i -> i < 200;
        Predicate<Integer> and = p.and(q);
        Predicate<Integer> n = p.negate();
        System.out.println(and.test(150));
        System.out.println(n.test(150));

        String a = "abc";
        String b = "abc";

        boolean result = Predicate.isEqual(a).test(b);
        System.out.println(result);


    }
}
