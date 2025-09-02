class Lecture08 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 08");

        // SELF-CHECK PROBLEMS:
        // Section 13.1: Searching and Sorting in the Java Class Libraries
        // 3. Should you use a sequential or binary search on an array of Point objects, Done!
        // and why?
        // if the array of Point objects is sorted by a specific property, such as x-coordinate or y-coordinate,
        // and efficiency is important, binary search is the preferable choice due to its log2(n) time complexity.
        // However, if the array is not sorted or if simplicity is valued over efficiency,
        // sequential search may be more appropriate.

        // 4. Under what circumstances can the Arrays.binarySearch and Done!
        // Collections.binarySearch methods be used successfully?
        // Both methods require the collection to be sorted in ascending order
        // according to the natural ordering of its elements or a specified comparator.
        // The methods assume that the collection already contains the element being searched for.
        // If the element does not exist in the collection, the result of the binary search may not be meaningful.

        // 5. In what order does the Collections.sort method arrange a list of strings? Done!
        // How could you arrange them into a different order?
        // The Collections.sort method arranges a list of strings in ascending natural order,
        // which is lexicographic order,also known as alphabetical order.
        // This means that strings are sorted based on their Unicode code point values

        // Section 13.2: Program Complexity
        // 9. Approximate the runtime of the following code fragment listed in Canvas Done!
        // The approximate runtime of this specific example is  log2(n)
        //The given code fragment is a while loop that iterates until the value of j exceeds or equals n.
        // In each iteration, the value of j is doubled.

        // 10. Approximate the runtime of the following code fragment listed in Canvas
        //  the total number of operations performed by the loop is proportional to (n-1) which is O(n)

        // 11. Approximate the runtime of the following code fragment listed in Canvas
        // it is going to be O(n^2)

        // Section 13.3: Implementing Searching and Sorting Algorithms
        // 16. What is the runtime complexity class of a sequential search on an Done!
        // unsorted array?
        // What is the runtime complexity class of the modified sequential search on a
        // sorted array?
        // The runtime complexity class of a sequential search on an unsorted array is O(n)
        // The runtime complexity class of the modified sequential search on a sorted array remains O(n)
        // Even though the array is sorted, the modified sequential search still needs to iterate
        // through all elements until it finds the target value or reaches a value greater than the target

        // 17. Why does the binary search algorithm require the input to be sorted? Done!
        // because it relies on the property of a sorted array where elements are arranged
        // in a specific order (e.g., ascending or descending).
        // This property enables the algorithm to efficiently
        // search for a target value by repeatedly dividing the search interval in half.

        // 18. How many elements (at most) does a binary search examine if the array  Done!
        // contains 60 elements?
        // it would examine at most 6 elements.
        // Since log2(60) = 5.91

        // 19. What indexes will be examined as the middle element by a binary search  Done!
        // for the target value 8 when the search is run on the following input arrays?
        // What value will the binary search algorithm return?

        // A. int[] numbers = {1, 3, 6, 7, 8, 10, 15, 20, 30};
        // The first step considers the entire array, so the first middle index is (0+8)/2=4
        // Step 1: Middle element at index 4 (value: 8)

        // B. int[] numbers = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        // Step 1: Middle element at index 4 (value: 5)
        // Step 2: Middle element at index 6 (value: 8)

        // C. int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Step 1: Middle element at index 4 (value: 5)
        // Step 2: Middle element at index 6 (value: 7)
        // Step 3: Middle element at index 7 (value: 8)

        // D. int[] numbers = {8, 9, 12, 14, 15, 17, 19, 25, 31};
        // Step 1: Middle element at index 4 (value: 15)
        // Step 2: Middle element at index 1 (value: 9)
        // Step 3: Middle element at index 0 (value: 8)

        // 20. What indexes will be examined as the middle element by a binary search Done!
        // for the target value 8 when the search is run on the following input array?
        // Notice that the input array isn’t in sorted order. What can you say about the
        // binary search algorithm’s result?

        // int[] numbers = {6, 5, 8, 19, 7, 35, 22, 11, 9};
        //If it is not sorted, binary search won't work. it will check the middle point (in this case 7)
        // 7<8 it will search the right half.
        // The binary search algorithm's result in this case would be that
        // the target value 8 is not found in the array.

        // 23. What modifications would you have to make to the selectionSort method to   Done!
        // cause it to sort an array of double values rather than one of integer values?

        // Change the parameter type of the method to accept an array of double values.
        // Update the comparisons inside the method to compare double values instead of integers.
        // Update the variable types and declarations to handle double values.

        // 24. Consider the following array: Done!

        // int[] numbers = {29, 17, 3, 94, 46, 8, –4, 12};
        // After a single pass of the selection sort algorithm (a single swap), what
        // would be the state of the array?

        // A. {–4, 29, 17, 3, 94, 46, 8, 12}
        // B. {29, 17, 3, 94, 46, 8, 12}
        // C. {–4, 29, 17, 3, 94, 46, 8, –4, 12}
        // D. {–4, 17, 3, 94, 46, 8, 29, 12}
        // E. {3, 17, 29, 94, –4, 8, 46, 12}

        // After a single pass of the selection sort algorithm (a single swap),
        // the state of the array would be:
        // {3, 17, 29, 94, -4, 8, 46, 12}

        // 25. Trace the execution of the selection sort algorithm as shown in this
        // section when run on the following input arrays.
        // Show each element that will be selected by the algorithm and where it will be
        // moved, until the array is fully sorted.

        // A. {29, 17, 3, 94, 46, 8, –4, 12}
        // Array after pass 1: {-4, 17, 3, 94, 46, 8, 29, 12}
        // Array after pass 2: {-4, 3, 17, 94, 46, 8, 29, 12}
        // Array after pass 3: {-4, 3, 8, 94, 46, 17, 29, 12}
        // Array after pass 4: {-4, 3, 8, 12, 46, 17, 29, 94}
        // Array after pass 5: {-4, 3, 8, 12, 17, 46, 29, 94}
        // Array after pass 6: {-4, 3, 8, 12, 17, 29, 46, 94}
        // Array after pass 7: {-4, 3, 8, 12, 17, 29, 46, 94}
        // Array after pass 8: {-4, 3, 8, 12, 17, 29, 46, 94}  Final sort.

        // B. {33, 14, 3, 95, 47, 9, –42, 13}
        // Array after pass 1: {-42, 14, 3, 95, 47, 9, 33, 13}
        // Array after pass 2: {-42, 3, 14, 95, 47, 9, 33, 13}
        // Array after pass 3: {-42, 3, 9, 95, 47, 14, 33, 13}
        // Array after pass 4: {-42, 3, 9, 13, 47, 14, 33, 95}
        // Array after pass 5: {-42, 3, 9, 13, 14, 47, 33, 95}
        // Array after pass 6: {-42, 3, 9, 13, 14, 33, 47, 95}
        // Array after pass 7: {-42, 3, 9, 13, 14, 33, 47, 95}
        // Array after pass 8: {-42, 3, 9, 13, 14, 33, 47, 95} Final sort.

        // C. {7, 1, 6, 12, –3, 8, 4, 21, 2, 30, –1, 9}
        // Array after pass 1: {-3, 1, 6, 12, 7, 8, 4, 21, 2, 30, -1, 9}
        // Array after pass 2: {-3, -1, 6, 12, 7, 8, 4, 21, 2, 30, 1, 9}
        // Array after pass 3: {-3, -1, 1, 12, 7, 8, 4, 21, 2, 30, 6, 9}
        // Array after pass 4: {-3, -1, 1, 2, 7, 8, 4, 21, 12, 30, 6, 9}
        // Array after pass 5: {-3, -1, 1, 2, 4, 8, 7, 21, 12, 30, 6, 9}
        // Array after pass 6: {-3, -1, 1, 2, 4, 6, 7, 21, 12, 30, 8, 9}
        // Array after pass 7: {-3, -1, 1, 2, 4, 6, 7, 21, 12, 30, 8, 9}
        // Array after pass 8: {-3, -1, 1, 2, 4, 6, 7, 8, 12, 30, 21, 9}
        // Array after pass 9: {-3, -1, 1, 2, 4, 6, 7, 8, 9, 30, 21, 12}
        // Array after pass 10: {-3, -1, 1, 2, 4, 6, 7, 8, 9, 12, 21, 30}
        // Array after pass 11: {-3, -1, 1, 2, 4, 6, 7, 8, 9, 12, 21, 30}
        // Array after pass 12: {-3, -1, 1, 2, 4, 6, 7, 8, 9, 12, 21, 30}  Final sort.

        // D. {6, 7, 4, 8, 11, 1, 10, 3, 5, 9}
        // Array after pass 1: {1, 7, 4, 8, 11, 6, 10, 3, 5, 9}
        // Array after pass 2: {1, 3, 4, 8, 11, 6, 10, 7, 5, 9}
        // Array after pass 3: {1, 3, 4, 8, 11, 6, 10, 7, 5, 9}
        // Array after pass 4: {1, 3, 4, 5, 11, 6, 10, 7, 8, 9}
        // Array after pass 5: {1, 3, 4, 5, 6, 11, 10, 7, 8, 9}
        // Array after pass 6: {1, 3, 4, 5, 6, 7, 10, 11, 8, 9}
        // Array after pass 7: {1, 3, 4, 5, 6, 7, 8, 11, 10, 9}
        // Array after pass 8: {1, 3, 4, 5, 6, 7, 8, 9, 10, 11} Final sort.
    }
}
