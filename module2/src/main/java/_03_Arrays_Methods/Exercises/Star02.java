package _03_Arrays_Methods.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Star02 {
    //   public static void main(String[] args) {
//        System.out.println("Input a string:");
//        String s = new Scanner(System.in).nextLine();
//        String a = "abc";
//        System.out.println(s);
//        if(s.equals(a))
//            System.out.println("Hello");
//        int res=0;
//        Scanner sc = new Scanner(System.in);
//        int[][] a = new int[5][5];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.println("Input number:");
//                res += sc.nextInt();
//            }
//            break;
//        }
//
//        System.out.println(res);
    //   }
    public static void main(String[] args) {
        int[][] arr1 = create2dArray();
        for (int[] arr : arr1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("The sum of diagonal1 of matrix is " + sumDiagonal(arr1));
        System.out.println("The sum of diagonal2 of matrix is " + sumDiagonal2(arr1));
    }

    // sum of diagonal
    public static int sumDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int sumDiagonal2(int[][] matrix){
        int sum=0;
//        for (int i = matrix.length-1,k=0; i >= 0; i--) {
//            sum+=matrix[k++][i];
//        }

        for (int i = 0; i < matrix.length; i++) {
            sum+= matrix[i][matrix.length-1-i];
        }
        return sum;
    }

    public static int[][] create2dArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input size of matrix: ");
        int size = Integer.parseInt(scanner.nextLine());
        int[][] arr2d = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr2d[i][j] = (int) Math.round(Math.random() * 100) + 1;
            }
        }
        return arr2d;
    }
}
