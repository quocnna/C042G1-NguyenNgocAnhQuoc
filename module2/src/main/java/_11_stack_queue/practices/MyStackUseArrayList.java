package _11_stack_queue.practices;

import java.util.ArrayList;

public class MyStackUseArrayList<T> {
    private ArrayList<T> stack;
    public MyStackUseArrayList(){
        stack = new ArrayList<>();
    }

    public void push(T t){
        stack.add(t);
    }
    public T pop(){
        return stack.remove(stack.size()-1);
    }
    public int size(){
        return stack.size();
    }
    public T get(int index){
        return stack.get(index);
    }
}

class TestMyStackUseArrayList{
    public static void main(String[] args) {
        MyStackUseArrayList<Integer> t = new MyStackUseArrayList();
        t.push(1);
        t.push(2);
        t.push(3);
        t.pop();
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t.get(i));
        }
    }
}