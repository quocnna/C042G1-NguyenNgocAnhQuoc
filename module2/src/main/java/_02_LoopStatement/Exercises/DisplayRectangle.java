package _02_LoopStatement.Exercises;

import java.util.Scanner;

public class DisplayRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        display(sc.nextInt());
    }
    private static void display(int a){
        switch (a){
            case 1:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 10; j++)
                        System.out.print("*");
                    System.out.println("");
                }
                break;
            case 2:
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j <= i; j++)
                        System.out.print("*");
                    System.out.println("");
                }
                break;
            case 3:
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7-i; j++)
                        System.out.print("*");
                    System.out.println("");
                };
                break;
            default:
                System.exit(0);
        }
    }
}
