package chapter14.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceStreamEx {
    public static void main(String[] args) {
        Student s1 = new Student("James",4.5,4);
        Student s2 = new Student("KoEunseong",3.9,1);
        Student s3 = new Student("SonHeungmin",2.1,3);
        Student s4 = new Student("LeeDaeho",4.3,2);
        Student s5 = new Student("Piters",4.0,2);
        Student s6 = new Student("Swings",4.3,4);
        Student s7 = new Student("Sushi",2.9,3);
        Student s8 = new Student("강은성",4.3,1);
        Student[] students = new Student[]{s1,s2,s3,s4,s5,s6,s7,s8};

        IntStream is1 = Stream.of(students).mapToInt(s->s.getName().length());
        IntStream is2 = Stream.of(students).mapToInt(s->s.getName().length());
        IntStream is3 = Stream.of(students).mapToInt(s->s.getName().length());
        IntStream is4 = Stream.of(students).mapToInt(s->s.getName().length());

        int count = is1.reduce(0,(a,b)->a+1);
        int sum = is2.reduce(0,(a,b)->a+b);

        OptionalInt max = is3.reduce(Integer::max);
        OptionalInt max2 = is4.max();
        System.out.println(count);
        System.out.println(sum);
        System.out.println(max.getAsInt());
        System.out.println(max2.getAsInt());
 


    }
}
