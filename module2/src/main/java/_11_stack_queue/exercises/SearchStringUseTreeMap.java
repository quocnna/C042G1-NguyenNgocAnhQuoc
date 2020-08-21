package _11_stack_queue.exercises;

import java.util.Scanner;
import java.util.TreeMap;

public class SearchStringUseTreeMap {
    public static void main(String[] args) {
        System.out.println("Input a string:");
        String st = new Scanner(System.in).nextLine();
        String[] a = st.toLowerCase().split("");
        TreeMap<Character,Integer> t= new TreeMap<>();
        int tmp=1;
        for (int i = 0; i < a.length; i++) {
            char c= a[i].charAt(0);
            if(!t.containsKey(c))
                t.put(c,tmp);
            else
                t.replace(c,tmp+1);
        }

        System.out.println(t);
    }
}
