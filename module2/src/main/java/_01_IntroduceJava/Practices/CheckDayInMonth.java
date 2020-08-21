package _01_IntroduceJava.Practices;

import java.util.Scanner;

public class CheckDayInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the month: ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.println(m==2?"28 or 29": checkMonth(m));
    }

    private static int checkMonth(int m){
        return (m==1 || m==3|| m==5 ||m==7||m==8||m==10||m==12)?31:(m==4 || m==6 || m==9|| m==11)?30:0;
    }
}
