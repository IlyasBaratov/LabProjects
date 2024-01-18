package Sort_Algorithms;

import java.util.Random;

public class Merge_sort {
    public static void main(String[] args) {
        Random rannum = new Random();
        int [] numbers = new int[100];
        for (int n = 0; n < 10; n++) {
            numbers[n] = rannum.nextInt(1000000);
        }
        System.out.println("Before: ");
        print_array(numbers);

        merge_array(numbers);
        System.out.println("\nAfter: ");
        print_array(numbers);

    }
    public static void merge_array(int [] array){
        int input_length = array.length;
        if (input_length<2){
            return;
        }
        int mid_index = input_length/2;
        int [] left_half = new int [mid_index];
        int [] right_half = new int[input_length-mid_index];
        for (int n = 0; n < mid_index; n++) {
            left_half[n] = array[n];
        }
        for (int n = mid_index; n < input_length ; n++) {
            right_half[n-mid_index] = array[n];
        }
        merge_array(left_half);
        merge_array(right_half);
//        Merging
        merge(array, left_half, right_half);
    }

    private static void merge(int [] input_array,int [] left_half, int [] right_half){
        int input_length = input_array.length;
        int n =0, i=0, j=0;
        while (n< left_half.length && i<right_half.length){
            if (left_half[n]<=right_half[i]){
                input_array[j] = left_half[n];
                n++;
            }
            else {
                input_array[j] = right_half[i];
                i++;
            }
            j++;
        }
        while (n<left_half.length){
            input_array[j] = left_half[n];
            j++;
            n++;
        }
        while (i<right_half.length){
            input_array[j] = right_half[i];
            j++;
            i++;
        }

    }

    private static void print_array(int [] numbers){
        for (int n = 0; n < numbers.length; n++) {
            System.out.println(numbers[n]);
        }
    }
}
