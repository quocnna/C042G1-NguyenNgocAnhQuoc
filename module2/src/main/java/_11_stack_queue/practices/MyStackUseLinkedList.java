package _11_stack_queue.practices;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class MyStackUseLinkedList<T> extends LinkedList<T> {
    private List<T> stack;

    public MyStackUseLinkedList() {
        stack = new LinkedList();
    }

    public void push(T element) {
        LinkedList<T> t= (LinkedList<T>)stack;
        t.addFirst(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        LinkedList<T> t= (LinkedList<T>)stack;
        return t.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public T get(int i){
        return stack.get(i);
    }
}
class TestMyGenericStack{
    private static void stackOfIStrings() {
        MyStackUseLinkedList<String> stack = new MyStackUseLinkedList();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1 Size of stack after push operations: " + stack.size());
        System.out.printf("1.2. Pop elements from stack : ");
        stack.pop();
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
        System.out.println("\n1.3. Size of stack after pop operations : " + stack.size());
    }
    private static void stackOfIntegers() {
        MyStackUseLinkedList<Integer> stack = new MyStackUseLinkedList();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2.1. Size of stack after push operations: " + stack.size());
        System.out.printf("2.2. Pop elements from stack : ");
        stack.pop();
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n3.3 Size of stack after pop operations : " + stack.size());
    }
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}

