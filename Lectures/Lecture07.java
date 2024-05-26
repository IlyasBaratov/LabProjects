import java.util.Scanner;

class Lecture07 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 07");
//        Scanner input = new Scanner(System.in);

        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // Put your answer for #8 here: Done!

        // A call stack is a mechanism used by programming languages to manage function calls.
        // When a function is called, the program allocates a stack frame,
        // which contains information about the function's parameters, local variables, and return address.

        // Put your answer for #9 here: Done!
        // Effectively, this change reverses the order in which lines are processed and printed.
        // Now, the method reads a line, prints it, and then recursively calls itself.
        // This would result in the lines being printed in their original order

        // Put your answer for #10 here: Done!
        // It will not print anything since every time Scanner is not empty it will recursively call itself.
        // Not reaching print statement, until it reaches to the end. and when it reaches the end,
        // whe while statement would be false.


        // Put your answer for #11 here: Done!

        // It will through StackOverflowError error.
        // here is the fixed version: See below -->
        // System.out.println(pow(2,5));

        // Put your answer for #17 here: Done!
        // Correct answer: See below-->
        int checking = 3456;
//        System.out.println(digitSum(checking));


        // EXERCISES:

        // Put your answer for #1 here: Done!
//        starString(1);
//        System.out.println();
//        starString(2);
//        System.out.println();
//        starString(3);

        // Put your answer for #2 here: Done!
//        writeNums(5);

        // Put your answer for #3 here: Done!
//        writeSequence(3);

        // Put your answer for #10 here: Done!
//        System.out.println(digitMatch(1072503891, 62530841));

        // Put your answer for #12 here: Done!
        String first = "HeLLo";
        String secong = "OlLeH";
//        System.out.println(isReverse(first,secong));

    }
    public static int pow(int x, int y) {
        int out = 1;
        if (y>0){
            out= x * pow(x, y - 1);
        }
        return out;
    }
    public static int digitSum(int n) {
        int answer=0;
        while (n/10>0){
            answer+=(n%10);
            n/=10;
        }
        answer+=n;
        return answer;
    }
    public static void starString (int number){
        if(number<0){
            throw new IllegalArgumentException("Input value cannot be less than 0");
        }
        if (number==0){
            System.out.print("*");
        }
        else {
            starString(number-1);
            starString(number-1);
        }
    }
    public static void writeNums(int number){
        if (number<0){
            throw new IllegalArgumentException("Input value cannot be less than 0");
        }
        else {
            for (int i = 1; i < number; i++) {
                System.out.print(i+", ");
            }
            System.out.print(number);
        }
    }
    public static void writeSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Input must be greater than or equal to 1");
        } else if (n == 1) {
            System.out.print("1");
        } else {
            System.out.print((n + 1) / 2 + " ");
            writeSequence(n - 1);
            if (n != 2) {
                System.out.print(" " + (n + 1) / 2);
            }
        }
    }
    public static int digitMatch(int number_1, int number_2){
        int out = 0;
        if (number_1==0 || number_2==0){
            return 0;
        }
        int last_1 = number_1 % 10;
        int last_2 = number_2 % 10;
        int remaining_1 = number_1/10;
        int remaining_2 = number_2/10;
        if (last_1 == last_2){
            out+=1;
        }
        else out+=0;
        return out+digitMatch(remaining_1, remaining_2);
    }
    public static boolean isReverse(String first, String second){
        if (first.isEmpty() && second.isEmpty() || first.length()==1 && second.length()==1){
            return true;
        }
        first = first.toLowerCase();
        second = second.toLowerCase();
        if (first.charAt(0)!=second.charAt(second.length()-1)){
            return false;
        }
        else {
            return isReverse(first.substring(1), second.substring(0,second.length()-1));
        }
    }
}