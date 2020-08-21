package _10_List.Practices;

import java.util.Arrays;

public class MyList<E> {
    private int size=0;
    private final int DEFAULT_CAPACITY=10;
    private  Object elements[];
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e){
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    private void ensureCapa(){
        int newSize = elements.length +1;
        elements = Arrays.copyOf(elements, newSize);
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}

class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
      //  System.out.println("element 6: "+listInteger.get(-1));
    }
}