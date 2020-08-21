package _02_LoopStatement.Practices;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int a, b;
        Scanner nhap = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = nhap.nextInt();
        System.out.println("Enter b: ");
        b = nhap.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);
        System.out.println(gcd(a,b)>0?"Greatest common divisor is: "+gcd(a,b):"Nothing");

    }
    private static int gcd(int a, int b){
        int max = Math.max(a,b);
        for (int i = max; i > 0; i--) {
            if(a%i==0 && b%i==0)
                return i;
        }
        return -1;
    }
}
