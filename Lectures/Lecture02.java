import java.util.ArrayList;
import java.util.Arrays;

class Lecture02 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 02");

        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // Put your answer for #1 here:    Done!
        // 1. What is an ArrayList? In what cases should you use an ArrayList rather
        // than an array?
        // It is a data structure provided by the Java Collections Framework.
        // It allow elements to add and remove easily.
        // The main reason is what I mentioned above.
        // Additionally, arrayList maintains the order of elements in which they are inserted. Elements can be accessed by their index.
        // In short,in Arraylist, there are a lot of methods that we cannot find in array and have to do
        // extra coding.

        // Put your answer for #3 here:     Done!
        // 3. Write the code to declare an ArrayList containing these elements. What is
        // the size of the list? What is its type?

        String [] array = {"It", "was", "a", "stormy", "night"};
        // The size of the array is 5. Type is String. The array can only take Strings.

        // Put your answer for #4 here:    Done!
        // 4. Write code to insert two additional elements, "dark" and "and", at the
        // proper places in the list to produce the following ArrayList as the result:
        // ["It", "was", "a", "dark", "and", "stormy", "night"]
        ArrayList<String> converted = new ArrayList<>(Arrays.asList(array));
        converted.add(3,"dark");
        converted.add(4,"and");
        System.out.println(converted.toString());

        // Put your answer for #5 here:    Done!
        // 5. Write code to change the second element’s value to "IS", producing the
        // following ArrayList as the result:
        // ["It", "IS", "a", "dark", "and", "stormy", "night"]
        converted.set(1,"IS");
        System.out.println(converted.toString());

        // Put your answer for #7 here:    Done!
        ArrayList <Integer> one_to_ten = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            one_to_ten.add(i*2);
        }
        System.out.println(one_to_ten.toString());
        // 7. Write code to declare an ArrayList holding the first 10 multiples of 2: 0,
        // 2, 4,..., 18. Use a loop to fill the list with the proper elements.

        // Put your answer for #9 here:    Done!
        // 9. Write code to print out whether or not a list of Strings contains the
        // value "IS". Do not use a loop.

        System.out.println(converted.contains("IS"));

        // Put your answer for #14 here:    Done!
        // 14. What is a wrapper class? Describe the difference between an int and an
        // Integer.
        // A wrapper class in Java is a class that wraps around a
        // data type (int, float, double...) and provides additional functionality.
        // All primitive data types have their own wrapper classes.
        // For example int --> Integer: Integer can be null while int cannot.
        // Basically Wrapper classes make it possible to use their primitive types as an object.

        // Put your answer for #13 here:    Done!
        // 13. The code that follows does not compile. Why not? Explain how to fix it.

        // It should be ArrayList<Integer> numbers = new ArrayList<>();
        // Because we cannot use primitive types directly as type arguments.
        // In Java generics work only with classes and Interfaces.

        // Put your answer for #15 here:    Done!
        // 15. Write the output produced when the following method is passed each of the
        // following lists:

        // A. [2, 6, 1, 8]
        // B. [30, 20, 10, 60, 50, 40]
        // C. [-4, 16, 9, 1, 64, 25, 36, 4, 49]


        // A. [1,2,6,8]
        // B. [10, 30, 40, 20, 60, 50]
        // C. [-4, 1, 25, 4, 16, 9, 64, 36, 49]

    }
}
