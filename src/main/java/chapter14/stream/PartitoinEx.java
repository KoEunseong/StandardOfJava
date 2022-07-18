package chapter14.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Member{
    String name;
    boolean isMale;
    int schoolYear;
    int ban;
    int score;

    public String getName() {
        return name;
    }
    public boolean isMale() {
        return isMale;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public int getBan() {
        return ban;
    }


    public int getScore() {
        return score;
    }

    public Member(String name, boolean isMale, int schoolYear, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.schoolYear = schoolYear;
        this.ban = ban;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", schoolYear=" + schoolYear +
                ", ban=" + ban +
                ", score=" + score +
                '}';
    }

    enum Level {
        HIGH,MID,LOW
    }
}
public class PartitoinEx {
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
        Map<Boolean, List<Member>> memBySex = Stream.of(members).collect(partitioningBy(Member::isMale));//기본분할
        Map<Boolean, Long> memNumBySex = Stream.of(members).collect(partitioningBy(Member::isMale,summingLong(Member::getScore)));
        //counting은 해당학생수, summingLong(Member::getScore)));를 쓰면 총점을 구할수 있다.
        List<Member> men = memBySex.get(true);
        List<Member> women = memBySex.get(false);
        System.out.println("여자의 총점 = " + memNumBySex.get(false));
        for(Member m : women){
            System.out.println(m.getName() + " "+ m.getScore());
        }

        Map<Boolean, Optional<Member>> topScoreBySex = Stream.of(members).collect(partitioningBy(
                Member::isMale,maxBy(comparingInt(Member::getScore))
        ));
        //성별 최고점
        System.out.println("여자 최고점 = " + topScoreBySex.get(false));


        Map<Boolean, Member> topScoreBySex2 = Stream.of(members).collect(
                partitioningBy(Member::isMale,
                        collectingAndThen(maxBy(comparingInt(Member::getScore)),
                                Optional::get
                )
            )
        );//Map의 요소를 Optional이 아닌 Member로 받는 법: collectingAndTen과 Optionall::get 같이사용

        System.out.println("남자 최고점 = " + topScoreBySex2.get(true));
        System.out.println("여자 최고점 = " + topScoreBySex2.get(false));

        Map<Boolean,Map<Boolean,List<Member>>> failedStuBySex = Stream.of(members).collect(
                partitioningBy(Member::isMale,partitioningBy(s->s.getScore()< 90))
        );
        List<Member> failedMaleMem = failedStuBySex.get(true).get(true); //성별 미달학생들 분류

        for(Member m : failedMaleMem){
            String name = m.getName();
            System.out.println("탈락된 남자들 = " + name);
        }

    }
}
