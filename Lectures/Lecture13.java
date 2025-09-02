import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Lecture13 {
    public static int size;
    public static void main(String[] args) {
        System.out.println("Hello from lecture 13");

        // Self-Check Problems:
        // Section 15.1: Simple ArrayIntList

        // 1. What is the difference between an array list’s size and its capacity?    Done!
        // What is the relationship between the two values? (Is one always larger or
        // smaller than the other, for instance?)

        // The size of an array list refers to the number of elements currently stored in the list.
        // It's essentially the count of elements that have been added to the list.

        // The capacity of an array list refers to the total number of elements that the list can currently
        // hold without needing to resize its internal array. It represents the maximum number of elements that the
        // list can contain before it needs to increase its capacity by reallocating memory.

        // 2. What fields must be included in the ArrayIntList class, and why is each Done!
        // Field important? Would the class still work correctly if we removed any of
        // these fields?

        // Each field serves a specific purpose, and removing any of them might impact the functionality of the class.
        // Removing any of the fields would likely result in a class that either lacks essential functionality or operates less efficiently.
        // For example, without the data field, the class couldn't store any elements, making it essentially useless.
        // Similarly, removing the size field would prevent accurate tracking of the number of elements,
        // leading to incorrect behavior in methods like size() or isEmpty().

        // 3. Why does the list class use a toString method rather than a print method? Done!

        // Implementing a print method directly within the list class would tightly couple the class to a specific
        // output mechanism (printing to the console), limiting its usability in other contexts
        // where printing might not be appropriate or desired.
        // By providing a toString method, the list class follows a widely accepted convention,
        // maintains separation of concerns, and offers flexibility in how its contents are presented to users.

        // 4. We wrote the class to have public methods called size (to read the number    Done!
        // of elements of the list) and get (to access the element value at a specific
        // index).
        // Why is this approach better than declaring the fields (such as size) public?

        // Encapsulation hides the internal state of an object and exposes only the necessary
        // functionality through well-defined interfaces (methods). By encapsulating fields and providing access through methods,
        // you control how the fields are accessed and modified, which helps maintain the integrity and consistency of the object's state.

        // 7. An element can be inserted at the beginning, middle, or end of an array  Done!
        // list.
        // Which of the three insertion points is the most computationally expensive,
        // and why? Which is the most expensive location to remove an element from the
        // list?

        // Inserting an element at the beginning of an array list is typically the most computationally expensive operation,
        // while removing an element from the beginning is also the most expensive.
        // When inserting an element at the beginning of an array list, all existing elements need to be shifted to the
        // right to make space for the new element. This operation requires iterating over all existing elements and
        // moving them one position to the right, which has a time complexity of O(n), where n is the number of elements in the list.
        // After shifting all elements, the new element can be placed at the beginning.

        // 8. Write methods called min and max that return the smallest and largest    Done!
        // values in the list respectively.
        // For example, if a variable called list stores [11, –7, 3, 42, 0, 14], the
        // call of list.min() should return –7 and the call of list.max() should return
        // 42. If the list is empty, the methods should throw an IllegalStateException.
        Integer [] a = {11, -7, 3, 42, 0, 14};
        List<Integer> list = new ArrayList<>(List.of(a));
        int min_value = min(list);
//        System.out.println(min_value);
        int max_value = max(list);
//        System.out.println(max_value);

        // Section 15.2: A More Complete ArrayIntList

        // 9. Describe the overall preconditions placed on the list class in this
        // section.
        // What assumptions do we make about how clients will use the list?

        // 10. What is the purpose of the checkIndex method?    Done!
        // Where is it called in the list class? Describe a way that the client can
        // utilize an ArrayIntList that will be caught by checkIndex.

        // The checkIndex method in an ArrayIntList class is typically used to validate whether
        // an index provided by the client is within the valid range of indices for the list.
        // Its purpose is to ensure that the index is not negative and does not exceed the bounds of the list's current size.

        // 11. What is the purpose of the checkCapacity method?   Done!
        // Where is it called in the list class? Describe a way that the client can
        // utilize an ArrayIntList that will be caught by checkCapacity.

        // The checkCapacity method in an ArrayIntList class is typically used to ensure that the list has
        // sufficient capacity to accommodate additional elements before performing an insertion operation.
        // Its purpose is to check whether the current capacity of the internal array is enough
        // to add more elements, and if not, to resize the array to increase its capacity.

        // 12. Once we check thoroughly for preconditions in the code, what data   Done!
        // invariants can we now assume about the list?
        // The size of the list (size) is always less than or equal to the capacity of the list (capacity).
        // In other words, the number of elements currently stored in the list does not exceed the maximum capacity of the list.
        // If the list does not allow null elements, then there are no null elements stored in the list.
        // This ensures that all elements stored in the list are valid non-null values.


        // 13. Why do we bother to add the contains, isEmpty, and remove methods to the   Done!
        // list class, when the client can already perform this same functionality with
        // the indexOf, size, and remove methods, respectively?

        // By providing dedicated methods such as contains and isEmpty, the code becomes more readable and expressive.
        // Clients can easily understand the purpose of these methods without needing to infer
        // functionality from other methods like indexOf or size.
        //

        // Exercises:
        // None
    }
    public static int min(List<Integer> list){
        int out=list.get(0);
        size = list.size();
        for (int i = 1; i < list.size(); i++) {
            check_index(i);
            if (out>list.get(i)){
                out = list.get(i);
            }
        }
        return out;
    }
    public static int max(List<Integer> list){
        int out = list.get(0);
        size = list.size();
        for (int i = 1; i < list.size(); i++) {
            check_index(i);
            if (out<list.get(i)){
                out = list.get(i);
            }
        }
        return out;
    }
    public static void check_index(int index){
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index: "+index+" Size: "+size);
        }
    }
}
