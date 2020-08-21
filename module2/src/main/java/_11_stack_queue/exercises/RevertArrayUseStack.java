package _11_stack_queue.exercises;

import java.util.Arrays;
import java.util.Stack;

public class RevertArrayUseStack {
    public static void main(String[] args) {
        int[] a = {1,2,9,4,5,3};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            stack.push(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            a[i]=stack.pop();
        }
        System.out.println(Arrays.toString(a));
    }
}
