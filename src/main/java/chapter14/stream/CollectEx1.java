package chapter14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectEx1 {
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

        List<Double> gradeStream = stream.map(s->s.getGrade()).toList();
        System.out.println("gradeStream = " + gradeStream);

        ArrayList<Student> stdStream = stream2.collect(Collectors.toCollection(ArrayList::new));
        for(Student s: stdStream){
            System.out.println(s.getName());
        }

        //Map<Integer,Student> map = stream3.collect(Collectors.toMap(p->p.getStd_num(),s->s));
        Map<Integer,String> map = stream3.collect(Collectors.toMap(s->s.getStd_num(),s->s.getName()));
        System.out.println("map = " + map);

        Student[] stdArr = stream4.toArray(Student[]::new);
        System.out.println(stdArr.length);

    }
}
