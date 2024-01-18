package Sort_Algorithms;
import java.util.Arrays;
import java.util.Random;
public class Bubble_sort{
    public static void main(String[] args) {
        Random rannum = new Random();
        int [] numbers = new int[10];
        for (int n = 0; n < 10; n++) {
            numbers[n] = rannum.nextInt(10000);
        }
        int temp;
        boolean swapped_sth =true;
        while (swapped_sth) {
            swapped_sth = false;
            for (int n = 0; n < numbers.length - 1; n++) {
                if (numbers[n] > numbers[n + 1]) {
                    swapped_sth = true;
                    temp = numbers[n];
                    numbers[n] = numbers[n + 1];
                    numbers[n + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
