package _14_sort_algorithm.exercises;

import java.util.Arrays;

public class BubbleSortDecrease {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }
    private static void bubbleSort(double[] list){
        boolean needNextPass=true;
        //for(int i=0; i<list.length-1; i++){
            for(int i=0; i<list.length-1 && needNextPass; i++){
            needNextPass =false;
            for(int j=0; j<list.length-i-1; j++){
                if(list[j]<list[j+1]){
                    double temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]= temp;
                    needNextPass= true;
                }
            }
        }
    }
}
