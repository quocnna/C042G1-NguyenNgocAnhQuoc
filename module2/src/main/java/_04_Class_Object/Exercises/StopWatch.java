package _04_Class_Object.Exercises;

import java.util.Arrays;
import java.util.Date;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.random;

public class StopWatch {
    private Date startTime;
    private Date endTime;
    public void start() {
        startTime = new Date();
    }
    public void stop() {
        endTime = new Date();
    }
    public float getElapsedTime() {
        return this.endTime.getTime() - this.startTime.getTime();
    }
    public static void main(String[] args) {
        StopWatch sw = new StopWatch();
        double[] arr1 = new double[500000];
        // create arr 100000 random
        for (int i = 0; i < 500000; i++) {
            arr1[i] = floor(random() * 100) + 1;
        }

        System.out.println("Array before sort");
        System.out.println(Arrays.toString(arr1));
        sw.start();
        Arrays.sort(arr1);
        //Sorting.SortArrays(arr1);
        //Sorting.SelectionSort(arr1);
        sw.stop();
        System.out.println("Array after sort");
        System.out.println(Arrays.toString(arr1));
        System.out.printf("Elapsed Time: %.2f ms.", sw.getElapsedTime());
    }
}

class Sorting {
    public static void SortArrays(double[] arr)
    {
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                double temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j = -1;
            }
        }
    }

    public static void SelectionSort(double[] arr) {
        final int _length = arr.length;
        int min;
        double temp;
        for (int i = 0; i < _length; i++) {
            min = i;
            for (int j = i + 1; j < _length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] =  arr[i];
            arr[i] = temp;
        }
    }
}
