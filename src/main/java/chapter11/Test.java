package chapter11;

class Person{
    int age;
    String name;
    Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person){
            Person tmp = (Person)obj;
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }
}
class a{

}

public class Test {
    public static void main(String[] args) {
        /*System.out.println("한글한글");
        String s = "1234";
        System.out.println(
        s.charAt(3)x
            */
        Person p = new Person(10 , "John");
        Person p2 = new Person(10,"John");
        System.out.println(p == p2);
        System.out.println(p.equals(p2));
        a ab = new a();
        a ab1 = new a();
        System.out.println(ab == ab1);
    }

}
