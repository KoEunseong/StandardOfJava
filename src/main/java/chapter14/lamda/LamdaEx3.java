package chapter14.lamda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LamdaEx3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<10;i++){
            list.add(i);
        }
        list.forEach(i->System.out.println(i));

        list.removeIf(x -> x % 2 == 0 || x % 3 ==0);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","2");
        map.put("3","4");
        map.forEach((k,v)->System.out.println(k + " " + v));

    }

}
