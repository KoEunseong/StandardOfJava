package chapter11;

import java.util.ArrayList;
import java.util.Collections;
public class ArrayListEx1 {
    @SuppressWarnings({"deprecation","unchecked"})
    public static void main(String[] args) {

        ArrayList list1 = new ArrayList(6);

        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        //list.add("스트링");

        ArrayList list2 = new ArrayList(list1.subList(1,4));
        System.out.println(list1);
        System.out.println(list2);

        Collections.sort(list1);
        System.out.println(list1);

        System.out.println(list1.containsAll(list2));
        System.out.println(list2.containsAll(list1));

        list2.add("B");
        list2.add("C");
        list2.add(3,"A");
        System.out.println(list2);

        list2.set(3,"AA");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        for(int i = list2.size() - 1;i>=0;i--){
            if(list1.contains(list2.get(i))){
                list2.remove(i);
            }
        }
        System.out.println(list2);



    }
}
