package _01_IntroduceJava.Practices;

import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the year:");
        int y = sc.nextInt();
        System.out.println(y%4== 0? y%100==0 ?y%400==0:true: false);
    }
}
