package chapter14.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectEx3 {
    public static void main(String[] args) {
        Student s1 = new Student("카은성",4.5,4);
        Student s2 = new Student("강은성",3.9,1);
        Student s3 = new Student("안은성",2.1,3);
        Student s4 = new Student("조은성",4.3,2);
        Student s5 = new Student("이은성",4.0,2);
        Student s6 = new Student("공은성",4.3,4);
        Student s7 = new Student("카은성",2.9,3);
        Student s8 = new Student("장은성",4.3,1);
        Stream<Student> stream = Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);

        IntStream is = new Random().ints(1,46).distinct().limit(6);
        IntStream is2 = new Random().ints(1,46).distinct().limit(6);
        IntStream is3 = new Random().ints(1,46).distinct().limit(6);

//        OptionalInt max = is.reduce(Integer::max);
        Optional<Integer> max = is.boxed().collect(reducing(Integer::max));
        System.out.println("max = " + max.get());

        long sum = is2.boxed().collect(reducing(0,(a,b)->a+b));
        System.out.println("sum = " + sum);

        double gradeTotal = stream.collect(reducing(0.0,Student::getGrade,Double::sum));
//      double gradetotal = stream.map(Student::getGrade).reduce(0.0,Double::sum);
        System.out.println("gradetotal = " + gradeTotal);
    }
}
