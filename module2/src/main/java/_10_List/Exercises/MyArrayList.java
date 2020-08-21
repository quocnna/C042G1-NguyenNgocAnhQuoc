package _10_List.Exercises;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<E> {
    private int size=0;
    static final int DEFAULT_CAPACITY=5;
    private E[] data = (E[]) new Object[DEFAULT_CAPACITY];

    public MyArrayList(){ }
    public MyArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }
    public void Add(int index, E e){
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        data[index] = e;
        size++;
    }
    public E Remove(int index){
        E[] temp =(E[]) new Object[size-1];
        size--;
        for (int i = 0,k=0; i < data.length; i++) {
            if(i==index)
                continue;
            temp[k++]=data[i];
        }
        data = temp;
        return data[index];
    }
    public int Size(){
        return size;
    }
    public E[] Clone(){
        return Arrays.copyOf(data,size);
    }
    public boolean Contain(E e){
        for (int i = 0; i < size; i++)
            if (e.equals(data[i]))
                return true;
        return false;
    }
    public int IndexOf(E e){
        for (int i = 0; i < size; i++)
            if (e.equals(data[i])) return i;
        return -1;
    }
    public boolean Add(E e){
        ensureCapacity();
        data[size]= e;
        size++;
        return false;
    }
    private void ensureCapacity(){
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }
    public E Get(int index){
        checkIndex(index);
        return data[index];
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
    }
    public void Clear(){
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

}

class MyArrayListTest{
    public static void main(String[] args) {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.Add(1);
        mal.Add(2);
        mal.Add(3);
        mal.Add(4);
        mal.Add(5);

        mal.Remove(2);
        for (int i = 0; i < mal.Size(); i++) {
            System.out.println(mal.Get(i));
        }
    }
}
