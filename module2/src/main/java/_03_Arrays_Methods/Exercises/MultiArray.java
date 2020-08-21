package _03_Arrays_Methods.Exercises;

public class MultiArray {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]= j;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
        }

        int res=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(res<matrix[i][j])
                    res= matrix[i][j];
            }
        }
        System.out.println(res);
    }
}
