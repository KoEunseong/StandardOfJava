package chapter14.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class MatchFindEx {
    public static void main(String[] args) {

        Student s1 = new Student("카은성",4.5,4);
        Student s2 = new Student("장은성",3.9,1);
        Student s3 = new Student("안은성",2.1,3);
        Student s4 = new Student("조은성",4.3,2);
        Student s5 = new Student("이은성",4.0,2);
        Student s6 = new Student("공은성",4.3,4);
        Student s7 = new Student("카은성",2.9,3);
        Student s8 = new Student("강은성",4.3,1);

        Stream<Student> stuStream = Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);

        boolean noFailed  = stuStream.anyMatch(s->s.getGrade() < 2.3);
        System.out.println(noFailed);

        stuStream =  Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);

        Optional<Student> freshMan1 = stuStream.sorted().filter(s->s.getSchool_year() < 2).findFirst();
        System.out.println(freshMan1);


    }
}
