package _14_sort_algorithm.exercises;

import java.util.Arrays;

public class QuickSortDecrease {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};

    public static void main(String[] args) {
        quickSort(list,0,list.length-1);
        System.out.println(Arrays.toString(list));
    }
    private static void quickSort(double[] list,int low, int high){
        if (low < high)
        {
            int pi = partition(list, low, high);
            quickSort(list, low, pi-1);
            quickSort(list, pi+1, high);
        }
    }

    private static int partition(double[] arr, int low, int high)
    {
        double pivot = arr[high];
        int i = low-1; // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or equal to pivot
            if (arr[j] > pivot)
            {
                i++;
                // swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}
