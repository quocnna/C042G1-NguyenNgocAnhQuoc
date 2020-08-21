package _14_sort_algorithm.exercises;

import java.util.Arrays;

public class SelectionSortDecrease {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        selectionSort(list);
        System.out.println(Arrays.toString(list));
    }
    private static void selectionSort(double[] list) {
        for (int i = 0; i < list.length-1; i++) {
            double currentMax = list[i];
            int currentMaxIndex=i;

            for (int j = i+1; j < list.length; j++) {
                if(currentMax<list[j]){
                    currentMax= list[j];
                    currentMaxIndex= j;
                }
            }

            if(currentMaxIndex!=i){
                list[currentMaxIndex]=list[i];
                list[i]=currentMax;
            }
        }
    }
}
