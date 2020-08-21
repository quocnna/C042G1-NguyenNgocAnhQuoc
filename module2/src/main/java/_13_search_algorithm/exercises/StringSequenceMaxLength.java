package _13_search_algorithm.exercises;

import java.util.LinkedList;

public class StringSequenceMaxLength {
    public static void main(String[] args) {
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        //String string= "abcabcdgabxy";
        String string= "abcabcdgabmnsxy";
        // Find the maximum consecutive increasingly ordered substring
        for (int i = 0; i < string.length(); i++) { 		// single loop
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear(); // Simple statement
            }

            list.add(string.charAt(i)); // Simple statement

            if (list.size() > max.size()) { // Simple statement
                max.clear();
                max.addAll(list);
            }
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch: max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();
    }

/*********************************************************************************
 * 	Analyze the time complexity of your program:                                  *
 * 	1 single loop * 3 simple statements = 3;                                      *
 * 	1 single loop * 1 simple statement = 1;                                       *
 *                                                                                *
 * 	T(n) = O(n) Linear time;                                                      *
 *********************************************************************************/
}
