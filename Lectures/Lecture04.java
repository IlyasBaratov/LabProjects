import java.util.*;

class Lecture04 {

    public static void main(String[] args) {
        System.out.println("Hello from lecture 04");
        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // 1. When should you use a LinkedList instead of an ArrayList? Done!
        // When we add or remove values from the list the best choice is going to be LinkedList,
        // because it doesn't need to create a brand-new list
        //              (as ArrayList does) and put those values + new value in it.
        // When we don't add anything but just call values from the list, ArrayList would be a better choice
        // because it gets at grabs that value in a random order.
        // meaning it does not need to go through each value to get the one we want


        // 2. Would a LinkedList or an ArrayList perform better when run on the Done!
        // following code? Why?
        // public static int min(List<Integer> list) {
        // int min = list.get(0);
        // for (int i = 1; i < list.size(); i++) {
        // if (list.get(i) < min) {
        // min = list.get(i);
        // }
        // }
        // return min;
        // }
        // In this case ArrayList would perform better than LinkedList.
        // Because it gets to that point in a random order meaning it does not have to go through
        // each element before that value to grab it. takes less time.

        // 3. What is an iterator? Why are iterators often used with linked lists? Done!

        // An iterator in Java is an interface provided by the java.util package
        // that allows iterating over the elements of a collection in a sequential manner,
        // without exposing the underlying implementation details of the collection.

        // Linked lists are often used with iterators because of their inherent structure.
        // Since linked lists consist of nodes where each node contains a reference to the next node,
        // traversing a linked list sequentially is a natural fit for iterator-based traversal.

        // 4. Write a piece of code that counts the number of duplicate elements in a Done!
        // linked list.
        // That is, the number of elements whose values are repeated at an earlier index
        // in the list. Assume that all duplicates in the list occur consecutively. For
        // example, the list [1, 1, 3, 5, 5, 5, 5, 7, 7, 11] contains five duplicates:
        Integer [] array = {1, 1, 3, 5, 5, 5, 5, 7, 7, 11};
//
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(array));
        Iterator<Integer> it = list.iterator();
        int current = it.next();
        int count = 1;
        while (it.hasNext()){
            int next_element = it.next();
            if (current == next_element){
                count+=1;
            }
            else {
                System.out.println(current + " is " + count + " time(s).");
                count=1;
                current = next_element;
            }
//
//
        }
        System.out.println(current + " is " + count + " time(s).");

        // one duplicate of element value 1, three duplicates of element value 5, and
        // one duplicate of element value 7.

        // 5. Write a piece of code that inserts a String into an ordered linked list of Done!
        // Strings, maintaining sorted order.
        // For example, for the list ["Alpha", "Baker", "Foxtrot", "Tango", "Whiskey"],
        // inserting "Charlie" in order would produce the list ["Alpha", "Baker",
        // "Charlie", "Foxtrot", "Tango", "Whiskey"].
        LinkedList<String> exercise_5 = new LinkedList<>();
        exercise_5.add("Alpha");exercise_5.add("Baker");exercise_5.add("Foxtrot");
        exercise_5.add("Tango");exercise_5.add("Whiskey");
        exercise_5.add(2,"Charlie");
        System.out.println(exercise_5);

        // From Section 11.2: Sets
        // 10. A List has every method that a Set has, and more. So why would you use a Done!
        // Set rather than a List?
        //  The primary feature of a Set is that it does not allow duplicate elements.
        //  If you need to ensure that your collection contains only unique elements,
        //  a Set is the appropriate choice.
        // Set implementations such as HashSet and TreeSet offer constant-time or
        // logarithmic-time complexity for operations like contains(Object o) and add(E e).

        // 11. When should you use a TreeSet, and when should you use a HashSet? Done!
        //  One of the primary features of a Set is that it does not allow duplicate elements.
        // Set implementations such as HashSet and TreeSet offer constant-time
        // or logarithmic-time complexity for operations like contains(Object o) and add(E e).
        // Set provides methods for set operations such as union, intersection,
        // difference, and subset checking (addAll, retainAll, removeAll, containsAll)

        // 12. A Set doesn’t have the get and set methods that an ArrayList has. How do Done!
        // you examine every element of a Set?
        // using iterator or forEach loop.

        // 13. What elements are contained in the following set after this code
        // executes?

        // Set<Integer> set = new HashSet<>();
        // set.add(74);
        // set.add(12);
        // set.add(74);
        // set.add(74);
        // set.add(43);
        // set.remove(74);
        // set.remove(999);
        // set.remove(43);
        // set.add(32);
        // set.add(12);
        // set.add(9);
        // set.add(999);

        // Elements are : [9, 12, 32, 999];

        // 14. How do you perform a union operation on two sets? An intersection? Try to   Done!
        // give an answer that doesn’t require any loops.
        Integer [] for_first = {1,2,3,4,5,6,7,8};
        Integer [] for_second = {1,12,45,4,5,76,7,8,356};
        Set<Integer> first = new HashSet<>(Arrays.asList(for_first));
        Set<Integer> second = new HashSet<>(Arrays.asList(for_second));
        second.addAll(first); // union method in Python
        System.out.println(second);
        second.retainAll(first); //  intersection method in Python
        System.out.println(second);



        // 15. Write the output produced when the following method is passed each of the Done!
        // following lists:

//         public static void mystery(List<String> list) {
//         Set<String> result = new TreeSet<>();
//         for (String element : list) {
//         if (element.compareTo(list.get(0)) < 0) {
//         result.add(element);
//         } else {
//         result.clear();
//         }
//         }
//         System.out.println(result);
//         }
        // [marty, stuart, helene, jessica, amanda]
        // [sara, caitlin, janette, zack, riley]
        // [zorah, alex, tyler, roy, roy, charlie, phil, charlie, tyler]

        // A. [amanda, helene, jessica]
        // B.[riley]
        // C. [alex, charlie, phil, roy, tyler]

        // Exercises:
        // 2. Write a method called alternate that accepts two Lists as its parameters Done!
        // and returns a new List containing alternating elements from the two lists, in
        // the following order:

        // First element from first list
        // First element from second list
        // Second element from first list
        // Second element from second list
        // Third element from first list
        // Third element from second list
        // . . .
        // If the lists do not contain the same number of elements, the remaining
        // elements from the longer list should be placed consecutively at the end. For
        // example, for a first list of [1, 2, 3, 4, 5] and a second list of [6, 7, 8,
        // 9, 10, 11, 12], a call of alternate(list1, list2) should return a list
        // containing [1, 6, 2, 7, 3, 8, 4, 9, 5, 10, 11, 12].
        Integer [] one = {1,2,3,4,5};
        Integer [] two = {6,7,8,9,10,11,12};
        List<Integer> list_1 = new ArrayList<>(Arrays.asList(one));
        List<Integer> list_2 = new ArrayList<>(Arrays.asList(two));
//        altarnate(list_1,list_2);

        // 9. Write a method hasOdd that accepts a set of integers as a parameter and Done!
        // returns true if the set contains at least one odd integer and false
        // otherwise.
        // If passed the empty set, your method should return false.
        Integer [] array_2 = {2,4,6,8,10};
        Set<Integer> set = new HashSet<>(Arrays.asList(array_2));
//        System.out.println(hasOdd(set));
    }
    public static void altarnate(List<Integer>first, List <Integer> second){
        List <Integer> out = new ArrayList<>();
        Iterator<Integer> one = first.iterator();
        Iterator<Integer> two = second.iterator();
        while (one.hasNext()|| two.hasNext()){
            if (one.hasNext()){
                out.add(one.next());
            }
            if (two.hasNext()){
                out.add(two.next());
            }
        }
        System.out.println(out);
    }
    public static boolean hasOdd(Set<Integer> set){
        Iterator<Integer> it = set.iterator();
        if (set.isEmpty()){
            return false;
        }
        while (it.hasNext()){
            if (it.next()%2==1){
                return true;
            }
        }

        return false;
    }
}
