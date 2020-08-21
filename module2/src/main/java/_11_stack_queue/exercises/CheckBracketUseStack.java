package _11_stack_queue.exercises;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracketUseStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        int left=0,right=0;
        boolean res=true;
        System.out.println("Input a string: ");
        String[] st = new Scanner(System.in).nextLine().split("");
        for (int i = 0; i < st.length; i++) {
            if("(".equals(st[i])){
                stack.push("(");
                left++;
            }
            else if(")".equals(st[i])) {
                if(!stack.contains("(")){
                    res= false;
                    break;
                }
                right++;
            }
        }

        System.out.println(res && left==right?"well":"invalid");
    }
}
