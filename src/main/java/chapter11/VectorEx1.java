package chapter11;

import java.util.Vector;

public class VectorEx1 {
    public static void main(String[] args) {
        Vector v = new Vector(5);
        v.add(1);
        v.add(2);
        v.add(3);
        print(v);

        v.trimToSize(); //빈공간을 없앤다.
        print(v);
        System.out.println();
        v.ensureCapacity(6);
        print(v);
        System.out.println();
        v.setSize(7);
        print(v);

    }
    public static void print(Vector v){
        System.out.println(v);
        System.out.println("size : " + v.size());
        System.out.println("capacity : " + v.capacity());

    }
}
