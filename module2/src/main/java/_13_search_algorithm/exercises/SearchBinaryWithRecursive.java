package _13_search_algorithm.exercises;

public class SearchBinaryWithRecursive {
    private static int binarySearch(int arr[], int low, int high, int value) {
        if (high >= low) {
            int mid =(high - low) / 2;
            if (arr[mid] == value) return mid;
            if (arr[mid] > value) return binarySearch(arr, low, mid - 1, value);
            return binarySearch(arr, mid + 1, high, value);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={6,13,14,25,33,43,51,53,64,74,84,93,95,96,97};
//        int min= Arrays.stream(a).min().getAsInt();
        System.out.println(binarySearch(a,0,a.length-1,25));
    }
}
