package _11_stack_queue.practices;

import java.util.ArrayList;

public class MyQueueUseArrayList<T> {
    private ArrayList<T> queue;
    public MyQueueUseArrayList(){
        queue = new ArrayList<>();
    }
    public void enqueue(T t){
        queue.add(0,t);
    }
    public T dequeue(){
        return queue.remove(queue.size()-1);
    }
    public int size(){
        return queue.size();
    }
    public T get(int index){
        return queue.get(index);
    }
}

class TestMyQueueUseArrayList{
    public static void main(String[] args) {
        MyQueueUseArrayList<Integer> a = new MyQueueUseArrayList<>();
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.dequeue();
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }
}
