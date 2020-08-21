package _01_IntroduceJava.Exercises;

import java.util.Scanner;

public class HelloMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the name:");
        System.out.println("Hello "+ sc.nextLine());
    }
}
