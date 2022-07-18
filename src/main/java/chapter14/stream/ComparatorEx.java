package chapter14.stream;

import java.util.Comparator;
import java.util.stream.Stream;

class StudentTest {
    String name;
    double grade;
    int school_year;

    public StudentTest(String name, double grade, int school_year) {
        this.name = name;
        this.grade = grade;
        this.school_year = school_year;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public int getSchool_year() {
        return school_year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", school_year=" + school_year +
                '}';
    }

}
public class ComparatorEx {
    public static void main(String[] args) {

        StudentTest s1 = new StudentTest("카은성",4.5,4);
        StudentTest s2 = new StudentTest("강은성",3.9,1);
        StudentTest s3 = new StudentTest("안은성",2.1,3);
        StudentTest s4 = new StudentTest("조은성",4.3,2);
        StudentTest s5 = new StudentTest("이은성",4.0,2);
        StudentTest s6 = new StudentTest("공은성",4.3,4);
        StudentTest s7 = new StudentTest("카은성",2.9,3);
        StudentTest s8 = new StudentTest("장은성",4.3,1);

        Stream<StudentTest> stream = Stream.of(s1,s2,s3,s4,s5,s6,s7,s8);
        stream.sorted(Comparator.comparing(StudentTest::getGrade)).forEach(System.out::println);


    }
}
