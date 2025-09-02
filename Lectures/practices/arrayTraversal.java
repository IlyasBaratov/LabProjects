package Practices;

public class arrayTraversal {
    public static void main(String[] args) {
        int [] a = {5,7,7,7,8,22,22,31,35,35,40,40,40,41};
        int [] b = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        System.out.println(second(a));
        System.out.println(second(b));

    }
    public static int second(int [] array){
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            if (i+1< array.length && array[i]!=array[i+1]){
                count+=1;
            }
        }
        return count;
    }
}
