package chapter14.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        String[] strArr = {"abc","def","ghi","aaa"};
        List<String> strList = Arrays.asList(strArr);
        Stream<String>  strStream1 = strList.stream();
        Stream<String>  strStream2 = Arrays.stream(strArr);

        strStream1.sorted().forEach(System.out::println);
        List<String> sortedList =  strStream2.sorted().collect(Collectors.toList());
        System.out.println(sortedList);
    }
}
