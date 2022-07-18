package chapter12.enums;
enum Direction2 { EAST , SOUTH, WEST, NORTH}

public class EnumEx1 {
    public static void main(String[] args) {
        Direction2 d1 = Direction2.EAST;
        Direction2 d2 = Direction2.valueOf("WEST");
        Direction2 d3 = Enum.valueOf(Direction2.class,"EAST");
        Direction2[] dArr = Direction2.values();

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d1.compareTo(d3));
        System.out.println(d1.compareTo(d2));
        System.out.println(d1 == d3);
        System.out.println(d1.equals(d3));

        for(Direction2 d : dArr){
            System.out.println(d +": " + d.ordinal());
        }



    }
}
