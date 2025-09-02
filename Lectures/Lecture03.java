import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Lecture03 {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello from lecture 03");

        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // 21. Consider the following variable declarations: Done!
//         Integer n1 = 15;
//         Integer n2 = 7;
//         Integer n3 = 15;
//         String s1 = "computer";
//        String s2 = "soda";
//         String s3 = "pencil";



        // Indicate whether the result of each of the following comparisons is positive,
        // negative, or 0:

        // A: positive (1);
        // n1.compareTo(n2)
        // B: zero (0);
        // n3.compareTo(n1)
        // C: negative (-1);
        // n2.compareTo(n1)
        // D: negative (-16);
        // s1.compareTo(s2)
        // E: positive (13);
        // s3.compareTo(s1)
        // F: zero (0);
        // s2.compareTo(s2)

        // 22. Use the compareTo method to write code that reads two names from the     Done!
        // console and prints the one that comes first in alphabetical order. For
        // example, the program’s output might look like the following:

        // Type a name: Tyler Durden
        // Type a name: Marla Singer
        // Marla Singer goes before Tyler Durden

        System.out.print("Type a name: ");
        String first = input.nextLine();
        System.out.print("Type a name: ");
        String second = input.nextLine();
        if (first.compareTo(second)>0){
            System.out.println(second+" goes before "+first);
        }
        else {
            System.out.println(first+" goes before "+second);
        }

        // 23. Write code to read a line of input from the user and print the words of
        // that line in sorted order, without removing duplicates. For example, the
        // program output might look like the following:

        // Type a message to sort:  to be or not to be that is the question
        // Your message sorted: be be is not or question that the to to

        exercise_23();

        // EXERCISES:

        // 20.    Done!
        CalendarDate app = new CalendarDate(1995,10,13);
        System.out.println(app.compareTo(new CalendarDate(2005,11,13)));
    }
    public static void exercise_23(){
        System.out.print("type a message to sort: ");
        String message = input.nextLine();
        String [] array = message.split("//s+");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list);
    }
}
// The CalendarDate class stores information about a single
// calendar date (month and day but no year).

class CalendarDate implements Comparable<CalendarDate> {
    private int month;
    private int day;
    private int year;


    public CalendarDate(int year, int month, int day ) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // Compares this calendar date to another date.
    // Dates are compared by month and then by day.
    public int compareTo(CalendarDate other) {
        if (year != other.year){
            return year- other.year;
        }
        else if (month != other.month) {
            return month - other.month;
        } else {
            return day - other.day;
        }
    }

    public int getMonth() {
        return month;
    }
    public int getYear(){
        return year;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return month + "/" + day;
    }
}

