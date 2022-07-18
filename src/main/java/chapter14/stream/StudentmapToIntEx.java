package chapter14.stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StudentmapToIntEx {
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
        DoubleStream stdtotalgrade = stream.mapToDouble(Student::getGrade);

        DoubleSummaryStatistics stat = stdtotalgrade.summaryStatistics();
        System.out.printf("학생그룹의 학점 평균은 %.2f\n",stat.getAverage());
        System.out.printf("학생그룹의 학생수는 %d",stat.getCount());






    }
}
