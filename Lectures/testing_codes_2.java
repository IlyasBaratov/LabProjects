import java.awt.*;
import java.util.Arrays;

public class testing_codes_2 {
    public static void main(String[] args) {
        generics();
    }
    public static void SelectionSort(int [] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            int indexOfmin = i;
            for (int j = i+1; j < array.length ; j++) {
                if (array[j]<min){
                    min = array[j];
                    indexOfmin = j;
                }
            }
            swap(array, i, indexOfmin);
        }
        System.out.println(Arrays.toString(array));
    }
    public static void swap (int [] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    public static void mystery(int number){
        System.out.print(number);
        if (number>=3){
            mystery(number/10);
        }
        if (number % 2 != 0){
            System.out.print("+");
        }
        else {
            System.out.print("-");
        }
    }
    public static boolean isPalidrome(String word){
        if (word.length()==1){
            return true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return isPalidrome(word.substring(1, word.length()-1));
        }
        else {
            return false;
        }
    }
    public static void generics(){
        var a = "this is var";
        System.out.println(a);
    }
}
