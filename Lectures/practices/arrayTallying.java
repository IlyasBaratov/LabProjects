package Practices;

import java.util.Arrays;

public class arrayTallying {
    public static void main(String[] args) {
        int number = 5;
        int [] array = {7,8,3,4,9,2,5,8,13,7};
        int [] answer = tallying(array,number);
//        System.out.println(Arrays.toString(answer));
        int quantity = 3;
        int a = quantity/10;
        int b = quantity%10;
        System.out.println(a+"   "+b);
    }
    public static int [] tallying (int [] array, int number){
        int [] out = new int[array.length-number];
        for (int i = 0; i < array.length - number; i++) {
            out[i] = array[i]+array[i+number];
        }
        return out;
    }
}
