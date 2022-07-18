package chapter14.stream;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectEx2 {
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
        Stream<Student> stream2 = Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);
        Stream<Student> stream3 = Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);
        Stream<Student> stream4 = Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);

        long count = stream.collect(counting());
        System.out.println("count = " + count);
        Double d = stream2.collect(summingDouble(Student::getGrade));
        System.out.println("d = " + d);
        Optional<Student> topStudent =
        stream3.collect(maxBy(Comparator.comparingDouble(Student::getGrade)));
        System.out.println("topStudent = " + topStudent);
        DoubleSummaryStatistics stat = stream4.collect(summarizingDouble(Student::getGrade));
        System.out.println(stat.getSum());

        IntStream intStream = new Random().ints(1,46).distinct().limit(6);
        Optional<Integer> max = intStream.boxed().collect(reducing(Integer::max));
        //boxed를 통해 IntStream -> Stream<Integer>로 변환
        System.out.println(max.get());




    }
}
