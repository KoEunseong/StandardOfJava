package chapter14.stream;

import java.io.File;
import java.util.Comparator;
import java.util.stream.Stream;

class Student implements Comparable<Student>{
    String name;
    double grade;
    int school_year;
    int std_num;
    static int sequence = 0;
    public Student(String name, double grade, int school_year) {
        this.name = name;
        this.grade = grade;
        this.school_year = school_year;
        this.std_num = sequence;
        sequence++;
    }

    public String getName() {
        return name;
    }

    public int getStd_num() {
        return std_num;
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

    @Override
    public int compareTo(Student s) {
        return this.name.compareTo(s.name);
    }
}
public class StudentSortStream {
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
        stream.sorted(Comparator.comparing(Student::getGrade).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);


    }
}
