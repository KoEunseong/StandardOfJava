package chapter14.stream;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class OptionalTest {
    public static void main(String[] args) {
        String s = "KoEunseong";
        Optional<String> o1 = Optional.of(s);
        Optional<String> o2 = Optional.of("KoEunseong");
        Optional<String> o3 = Optional.of(new String("abc"));
        Optional<String> oN = Optional.ofNullable(null);

        int result = optStrToInt(Optional.of("abc").filter(x->x.length()>2),-1);
        System.out.println(result);
        String str = "aa";

        if(Optional.ofNullable(str).isPresent())
            System.out.println(str);

        Optional.ofNullable(str).ifPresent(System.out::println);


        OptionalInt opt1 = OptionalInt.of(0);
        OptionalInt opt2 = OptionalInt.empty(); //똑같이 0이 저장

        System.out.println(opt1.isPresent()); //t
        System.out.println(opt2.isPresent()); //f

        System.out.println(opt1.getAsInt()); //0
        System.out.println(opt1); //OptionalInt[0]
        System.out.println(opt2); //OptionalInt.empty
        //System.out.println(opt2.getAsInt()); //Exception

        System.out.println(opt1.equals(opt2)); //f

        Optional<String> opt3 = Optional.ofNullable(null);
        Optional<String> opt4 = Optional.empty();
        System.out.println(opt3.equals(opt4));



    }
        static int optStrToInt(Optional<String> optStr, int defaultVaule){
            try{
                return optStr.map(Integer::parseInt).get();
            }
            catch(Exception e){
                return defaultVaule;
            }
        }
}
