import java.util.Arrays;

public class Binary_search_algorythm {
    public static void main(String[] args) {
        int [] numers = new int [100];
        for (int i = 1; i <= numers.length; i++) {
            numers[i-1] = i;
        }
//        System.out.println(binarySearch(numers, 87));

        System.out.println(binary_search_with_recursion(numers, 89,0, numers.length-1 ));

    }
    public static int binarySearch(int [] numbers, int numberToFind){
        int low = 0;
        int high = numbers.length-1;

        while (low<=high){
            int middle_pos = (low+high)/2;
            int middle_number = numbers[middle_pos];
            if (numberToFind == middle_number){
                return middle_pos;
            }
            if (numberToFind<middle_number){
                high = middle_pos-1;
            }
            else {
                low = middle_pos+1;
            }
        }
        return -1;
    }
    public static int binary_search_with_recursion(int [] numbers,int number_to_find, int low, int high){
        if (high>=low && low<=numbers.length-1){
            int mid_pos = low + (high-low)/2;
            int mid_num = numbers[mid_pos];
            if (number_to_find == mid_num){
                return mid_pos;
            }
            if (number_to_find<mid_num){
                return binary_search_with_recursion(numbers, number_to_find, low, mid_pos-1);
            }
            else {
                return binary_search_with_recursion(numbers, number_to_find, mid_pos-1, high);
            }
        }
        return -1;
    }
}
