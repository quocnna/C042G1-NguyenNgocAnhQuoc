package _03_Arrays_Methods.Exercises;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class AddingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input length array: ");
        int length = sc.nextInt();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Input a number");
            a[i] = sc.nextInt();
        }
        System.out.println("Input a index:");
        int index = sc.nextInt();
        while (index > length || index < 0) {
            System.out.println("Input a index again");
            index = sc.nextInt();
        }

        int[] b = new int[a.length + 1];
        for (int i = 0, k = 0; i < b.length; i++) {
            if (i == index) {
                b[i] = 8;
                continue;
            }
            b[i] = a[k++];
        }

        //a= ArrayUtils.add(a,index,5);
        System.out.println("After adding element");
        for (int e : b)
            System.out.println(e);
    }
}
