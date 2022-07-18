package chapter14.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class GroupingEx {
    public static void main(String[] args) {
        Member[] members = {
                new Member("강은성", false, 4, 1, 80),
                new Member("고은성", true, 3, 1, 100),
                new Member("김은성", true, 4, 3, 90),
                new Member("장은성", false, 4, 2, 40),
                new Member("정은성A", true, 4, 2, 95),
                new Member("짐은성", false, 2, 1, 89),
                new Member("정은성B", true, 2, 3, 70)
        };

        Map<Integer, List<Member>> memByBan = Stream.of(members).collect(groupingBy(Member::getBan)); // toList생략
        Map<Integer, List<Member>> memByGrade = Stream.of(members).collect(groupingBy(Member::getSchoolYear)); // toList생략
        //Map<Integer, HashSet<Member>> memByGrade = Stream.of(members).collect(groupingBy(Member::getSchoolYear, toCollection(HashSet::new))); // toList생략

        for(List<Member> ban :memByBan.values()){
            for(Member m : ban){
                System.out.println("m = " + m);
            }
        }
        System.out.println();




        Map<Member.Level,Long> memByLevel = Stream.of(members).collect(groupingBy(m->{
                if(m.getScore()>=90) return Member.Level.HIGH;
                else if (m.getScore()>=75) return Member.Level.MID;
                else return Member.Level.LOW;
                }, counting())
        ); //등급별 그룹화

        System.out.println("memByLevel = " + memByLevel);

        Map<Integer,Map<Integer,List<Member>>> memByGradeAndBan = Stream.of(members).collect(
                groupingBy(Member::getSchoolYear, groupingBy(Member::getBan)
        )); //학년별로 그룹화 한후 다시 반별로 그룹화

        for(Map<Integer,List<Member>> hak : memByGradeAndBan.values()){
            for(List<Member> ban : hak.values()){
                System.out.println();
                for(Member m : ban)
                    System.out.println("m = " + m);
            }
        }


        Map<Integer,Map<Integer,Member>> topMemGradeAndBan = Stream.of(members).collect(
                groupingBy(Member::getSchoolYear,
                        groupingBy(Member::getBan,
                        collectingAndThen(
                                maxBy(comparingInt(Member::getScore)), Optional::get
                        )
                    )
        )); //위 코드를 발전시켜 colleingAndThen, MaxBy를 써서 각반의 1등을 출력







    }
}
