package chapter11;

import java.util.ArrayList;

public class ArrayListEx2 {
    public static void main(String[] args) {
        final int LIMIT = 10;
        String s = "0123456789abcdefghijklmnopqrstuvwxyz";
        int length = s.length();

        ArrayList list = new ArrayList(length / LIMIT + 10);
        for(int i = 0; i < length;i+=LIMIT){
            if( i + LIMIT < length){
                list.add(s.substring(i,i + LIMIT));
            }
            else {
                list.add(s.substring(i));
            }
        }
        for(int i = 0 ; i < list.size();i++){
            System.out.println(list.get(i));
        }

    }
}
