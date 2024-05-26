import java.util.Arrays;

class Lecture11 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 11");

        // Self-Check Problems:
        // Section 13.4: Case Study: Implementing Merge Sort


        // 30. Trace the complete execution of the merge sort algorithm when called on  Done!
        // each array below.
        // Show the sub-arrays that are created by the algorithm and show the merging of
        // sub-arrays into larger sorted arrays.

        // A. {29, 17, 3, 94, 46, 8, –4, 12}
        // I wrote the algorithm down below.
        // sub-arrays:
        //          {29, 17, 3, 94} and {46, 8, -4, 12}
        //          {29, 17} and {3, 94} and {46, 8} and {-4, 12}
        //          {29} and {17} and {3} and {94} and {46} and {8} and {-4} and {12}
        // Merging steps:
        //          {17, 29} and {3, 94} and {8, 46} and {-4, 12}
        //          {3, 17, 29, 94} and {-4, 8, 12, 46}
        //          {-4, 3, 8, 12, 17, 29, 46, 94}
        // Final array = {-4, 3, 8, 12, 17, 29, 46, 94}

        // B. {6, 5, 3, 7, 1, 8, 4, 2}

        // Sub-arrays:
        //          {6, 5, 3, 7} and {1, 8, 4, 2}
        //          {6, 5} and {3, 7} and {1, 8} and {4, 2}
        //          {6} and {5} and {3} and {7} and {1} and {8} and {4} and {2}
        // Merging steps:
        //          {5, 6} and {3, 7} and {1, 8} and {2, 4}
        //          {3, 5, 6, 7} and {1, 2, 4, 8}
        //          {1, 2, 3, 4, 5, 6, 7, 8}
        // Final array: {1, 2, 3, 4, 5, 6, 7, 8}

        // C. {33, 14, 3, 95, 47, 9, –42, 13}
        //
        // Sub-arrays:
        //          {33, 14, 3, 95} and {47, 9, -42, 13}
        //          {33, 14} and {3, 95} and {47, 9} and {-42, 13}
        //          {33} and {14} and {3} and {95} and {47} and {9} and {-42} and {13}
        // Merging steps:
        //          {14, 33} and {3, 95} and {9, 47} and {-42, 13}
        //          {3, 14, 33, 95} and {-42, 9, 13, 47}
        //          {-42, 3, 9, 13, 14, 33, 47, 95}
        // Final array = {-42, 3, 9, 13, 14, 33, 47, 95}

        // Exercises:

        // 11. Using the following arrays, trace the complete execution of the merge
        // sort algorithm when called on each array.
        // Show the subarrays that are created by the algorithm and show the merging of
        // subarrays into larger sorted arrays.

        // A. int[] numbers3 = {8, 5, –9, 14, 0, –1, –7, 3};

        // Sub-arrays:
        //          {8, 5, -9, 14} and {0, -1, -7, 3}
        //          {8, 5} and {-9, 14} and {0, -1} and {-7, 3}
        //          {8} and {5} and {-9} and {14} and {0} and {-1} and {-7} and {3}
        // Merging:
        //          {5, 8} and {-9, 14} and {-1, 0} and {-7, 3}
        //          {-9, 5, 8, 14} and {-1, 0, -7, 3}
        //          {-9, -1, 0, 3, -7, 5, 8, 14}
        // Final array = {-9, -1, 0, 3, -7, 5, 8, 14}

        // B. int[] numbers4 = {15, 56, 24, 5, 39, –4, 27, 10};

        // Sub-arrays:
        //          {15, 56, 24, 5} and {39, -4, 27, 10}
        //          {15, 56} and {24, 5} and {39, -4} and {27, 10}
        //          {15} and {56} and {24} and {5} and {39} and {-4} and {27} and {10}
        // Merging:
        //          {15, 56} and {5, 24} and {-4, 39} and {10, 27}
        //          {5, 15, 24, 56} and {-4, 10, 27, 39}
        //          {-4, 5, 10, 15, 24, 27, 39, 56}
        // Final array = {-4, 5, 10, 15, 24, 27, 39, 56}

        // 13. Using the following arrays, trace the complete execution of the merge
        // sort algorithm when called on each array.
        // Show the subarrays that are created by the algorithm and show the merging of
        // subarrays into larger sorted arrays.

        // A. int[] numbers5 = {22, 44, 11, 88, 66, 33, 55, 77};

        // Sub-arrays:
        //          {22, 44, 11, 88} and {66, 33, 55, 77}
        //          {22, 44} and {11, 88} and {66, 33} and {55, 77}
        //          {22} and {44} and {11} and {88} and {66} and {33} and {55} and {77}
        // Merging:
        //          {22, 44} and {11, 88} and {33, 66} and {55, 77}
        //          {11, 22, 44, 88} and {33, 55, 66, 77}
        //          {11, 22, 33, 44, 55, 66, 77, 88}
        // Final array = {11, 22, 33, 44, 55, 66, 77, 88}


        // B. int[] numbers6 = {–3, -6, -1, -5, 0, -2, -4, -7};

        // Sub-arrays:
        //          {-3, -6, -1, -5} and {0, -2, -4, -7}
        //          {-3, -6} and {-1, -5} and {0, -2} and {-4, -7}
        //          {-3} and {-6} and {-1} and {-5} and {0} and {-2} and {-4} and {-7}
        // Merging:
        //          {-6, -3} and {-5, -1} and {-2, 0} and {-7, -4}
        //          {-6, -5, -3, -1} and {-7, -4, -2, 0}
        //          {-7, -6, -5, -4, -3, -2, -1, 0}
        // Final array = {-7, -6, -5, -4, -3, -2, -1, 0}
    }
    public static void merge_sort(int [] numbers){
        int number_length = numbers.length;
        if (number_length<2){
            return;
        }
        int mid_index = number_length/2;
        int [] left_half = new int[mid_index];
        int [] right_half = new int[number_length-mid_index];
        for (int i = 0; i < mid_index; i++) {
            left_half[i] = numbers[i];
        }
        for (int i = mid_index; i < number_length; i++) {
            right_half[i - mid_index] = numbers[i];
        }
        merge_sort(left_half);
        merge_sort(right_half);
        merge(numbers, left_half, right_half);
    }
    private static void merge(int [] number_legth, int [] left_half, int [] right_half){
        int i=0, j=0, k=0;
        while (i < left_half.length && j < right_half.length){
            if (left_half[i]<=right_half[j]){
                number_legth[k] = left_half[i];
                i++;
            }
            else {
                number_legth[k] = right_half[j];
                j++;
            }
            k++;

        }
        while (i < left_half.length){
            number_legth[k] = left_half[i];
            i++;
            k++;
        }
        while (j < right_half.length){
            number_legth[k] = right_half[j];
            j++;
            k++;
        }
    }
}