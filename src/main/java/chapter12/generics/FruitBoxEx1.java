package chapter12.generics;

import java.util.ArrayList;

class Box<T> {
    ArrayList<T> list = new ArrayList<T>();
    void add(T item){
        list.add(item);
    }
    T get(int i){
        return list.get(i);
    }
    int size() { return list.size();}
    public String toString(){
        return list.toString();
    }
}
interface Eatable {}
class Fruit implements Eatable{
    @Override
    public String toString(){
        return "Fruit";
    }
}
class Apple extends Fruit{
    @Override
    public String toString(){
        return "Apple";
    }
}
class Toy{

}
class FruitBox<T extends Fruit & Eatable> extends Box<T>{
}
public class FruitBoxEx1 {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
        FruitBox<Apple> appleBox = new FruitBox<Apple>();


    }
}
