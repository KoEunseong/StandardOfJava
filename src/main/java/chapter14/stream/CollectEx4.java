package chapter14.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectEx4 {
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

        String str1 = stream.map(Student::getName).collect(joining());
        String str2 = stream2.map(Student::getName).collect(joining(","));
        String str3 = stream3.map(Student::getName).collect(joining(",","[","]"));

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);


    }
}
