package _13_search_algorithm.practices;

import java.util.*;

public class AlgorithmComplexity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

//        int[] frequentChar = new int[255];
//        for (int i = 0; i < inputString.length(); i++) {
//            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
//            int ascii = (int) inputString.charAt(i);
//            /* Tăng giá trị tần suất */
//            frequentChar[ascii] += 1;
//        }
//        int max = 0;
//        char character = (char) 255; /* empty character */
//        for (int j = 0; j < 255; j++) {
//            if (frequentChar[j] > max) {
//                max = frequentChar[j];
//                character = (char) j;
//            }
//        }
//        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");

        String[] a = inputString.toLowerCase().split("");
        TreeMap<Character,Integer> t= new TreeMap<>();
        int tmp=1;
        for (int i = 0; i < a.length; i++) {
            char c= a[i].charAt(0);
            if(!t.containsKey(c))
                t.put(c,tmp);
            else
                t.replace(c,tmp+1);
        }

        Map.Entry<Character,Integer> r= t.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(r);
    }

//    private static  <K, V extends Comparable<V>> V maxUsingStreamAndLambda(Map<K, V> map) {
//        Optional<Map.Entry<K, V>> maxEntry = map.entrySet()
//                .stream()
//                .max((Map.Entry<K, V> e1, Map.Entry<K, V> e2) -> e1.getValue()
//                        .compareTo(e2.getValue())
//                );
//        return maxEntry.get().getValue();
//    }
}
