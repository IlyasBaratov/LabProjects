import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Lecture14 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 14");

        // Self-Check Problems:
        // Section 15.3: Advanced Features
        // 14. When this new version of the class fills to its capacity, it resizes.   Done!
        // How much does it grow? Why choose this growth rate, rather than increasing
        // the capacity by a single element or other constant amount?

        // A growth factor of doubling the capacity (i.e., increasing by a factor of 2) is a popular choice in many implementations.
        // By doubling the capacity, the amortized time complexity of adding elements to the array list remains constant.
        // Even though resizing the array involves copying elements, it occurs infrequently (typically logarithmically)
        // and has a relatively low cost compared to the number of elements added.

        // 15. What is the benefit of adding an iterator to the list class?   Done!
        // An iterator simplifies the process of iterating over the elements of the list.
        // It encapsulates the logic for traversing the elements, abstracting away the details
        // of the underlying data structure. This simplification leads to cleaner, more readable client code.

        // 16. What state does the array list iterator store? Done!

        // The array list iterator stores the state necessary to traverse the
        // elements of the array list in a predictable and efficient manner.
        // It tracks the current position, direction of iteration, and any relevant information needed to ensure safe
        // and accurate iteration over the elements of the array list.

        // 17. How does the array list iterator know if there are more elements left to    Done!
        // examine?
        // What does it do if the client tries to examine a next element but there are
        // none left to examine?

        // The array list iterator knows if there are more elements left to examine
        // by comparing its current position to the size of the array list.
        // As long as its position is within the bounds of the array list,
        // there are more elements remaining to examine. Once it reaches the end of the array list,
        // it knows that there are no more elements left to iterate over.

        // 18. What is a precondition of the iterator’s remove method?    Done!
        // How does the iterator enforce this precondition, and what does it do if the
        // precondition is violated?

        // The precondition of the iterator's remove method is that it can only be called after
        // a call to the next method has been made, and it can only be called once for each call to next.
        // If the remove method is called without a preceding call to next,
        // or if remove is called more than once for a single call to next, the iterator throws an IllegalStateException

        // 19. Write a method called sum that returns the sum of all values in the list.    Done!
        // For example, if a variable called list stores [11, –7, 3, 42, 0, 14], the
        // call of list.sum() should return 63. If the list is empty, sum should return
        // 0.

        Integer [] array = {11, -7, 3, 42, 0, 14};
        List<Integer> list = new ArrayList<>(List.of(array));
        int sum_of_all = sum(list);
//        System.out.println(sum_of_all);

        // 20. Write a method called average that returns the average of the values in    Done!
        // the list as a real number.
        // For example, if a variable called list stores [11, –7, 3, 42, 0, 14], the
        // call of list.average() should return 10.5. If the list is empty, average
        // should return 0.0.

        double average_of_all = average(list);
//        System.out.println(average_of_all);

        // Section 15.4: ArrayList<E>
        // 21. What problem do we encounter when we try to construct an array of type E?   Done!
        // How do we resolve this problem?

        // When we try to construct an array of a parameterized type E directly like this:
        // E[] array = new E[size];
        // We encounter a problem because Java does not allow the creation of arrays with a generic type due to type erasure.
        // To fix it, we should write it as following:


        // Object[] tempArray = new Object[size];
        // E[] array = (E[]) tempArray;

        // 22. Since our list stores an unfilled array, the empty elements were filled    Done!
        // with the value 0 when our array was full of integers.
        // What value occupies the empty cells when our list stores values of type E?

        // In Java, when an array of a reference type (such as E[]) is created but not fully populated,
        // the elements are initialized to the default value for the reference type.
        // For generic types like E, the default value is null.

        // 23. What changes need to be made to the indexOf method to search for objects
        // of type E in the new list class, and why are these changes necessary?

        // First, modify the method signature to specify that it searches for objects of type E.
        // Second, instead of using the == operator for equality comparison,
        // use the equals method to compare objects of type E.



        // 24. What is an annotation? How are annotations useful in writing our   Done!
        // ArrayList<E> class?

        // Annotations are a form of metadata that can be added to Java code to provide information
        // about the code to the compiler, runtime environment, or other tools.
        // Annotations are marked with the @ symbol followed by the annotation name.
        // Annotations can be used to add documentation or comments directly into the code,
        // providing additional information about the purpose or behavior of specific elements in the class.
        // This can improve code readability and maintainability.

        // 25. Why is it important to set empty elements to null when we are clearing or    Done!
        // removing from the list of type E, when we didn’t need to clear out these
        // elements in the previous ArrayIntList?
        // If we don't set removed elements to null, they will still reference objects in memory.
        // If the list is holding onto these references unnecessarily, it can lead to memory leaks,
        // where memory is occupied by objects that are no longer needed but cannot be garbage collected
        // because they are still referenced by the list. Setting removed elements
        // to null allows these objects to be garbage collected, freeing up memory.

        // 26. What is one benefit of making the list iterator into an inner class?    Done!

        //  By making the iterator an inner class of the list, it gains access to the private members of the list,
        //  such as the array storing the elements or the current size of the list.
        //  This allows the iterator to iterate over the elements of the list directly without exposing
        //  the internal implementation details to external classes.

        // Exercises:
        // None

    }
    public static int sum (List<Integer> list){
        int out=0;
        Iterator<Integer> iterator= list.iterator();
        if (list.isEmpty()){
            return 0;
        }
        while (iterator.hasNext()){
            int a = iterator.next();
            out+=a;
        }
        return out;
    }
    public static double average (List<Integer> list){
        double out=0;
        Iterator<Integer> iterator= list.iterator();
        if (list.isEmpty()){
            return 0;
        }
        while (iterator.hasNext()){
            int a = iterator.next();
            out+=a;
        }
        return out/list.size();
    }
}
