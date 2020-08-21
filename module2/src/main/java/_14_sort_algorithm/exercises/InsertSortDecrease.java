package _14_sort_algorithm.exercises;

import java.util.Arrays;

public class InsertSortDecrease {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }

    private static void insertionSort(double []list){
        for (int i = 1; i < list.length; i++){
            double currentElement = list[i];
            int k=0;
            for(k = i - 1; k >=0 && list[k] < currentElement; k--) {
                list[k+1] = list[k];
            }
            list[k+1] = currentElement;
        }
    }
}
