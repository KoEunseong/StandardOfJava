package chapter11;

import java.util.ArrayList;

public class MyStack {
    ArrayList e = new ArrayList(100);
    public Object push(Object item){
        e.add(item);
        return item;
    }

    public Object pop(){
        Object o = e.get(e.size() -1);
        e.remove(e.size() - 1);
        return o;
    }


    public boolean empty(){
        return e.size() == 0;
    }


}
