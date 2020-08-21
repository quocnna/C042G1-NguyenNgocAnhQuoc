package _03_Arrays_Methods.Exercises;

import java.util.Scanner;

public class Star03 {
    public static void main(String[] args) {
        String[] s = "Hello World".split("");
        System.out.print("Input a character:");
        char ch = new Scanner(System.in).next().charAt(0);
        int count= 0;
        for (int i = 0; i < s.length; i++)
            if(s[i].charAt(0) == ch)
                count++;

        System.out.println(count);
    }
}
