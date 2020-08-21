package _11_stack_queue.exercises;

import java.util.Scanner;
import java.util.Stack;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        System.out.println("Input a number: ");
        int d = new Scanner(System.in).nextInt();
        Stack<Integer> res = new Stack<>();
        while (d!=0) {
            res.push(d%2);
            d/=2;
        }

        while (!res.isEmpty()){
            System.out.print(res.pop());
        }
    }
}
