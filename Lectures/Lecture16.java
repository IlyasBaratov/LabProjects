import java.util.Iterator;
import java.util.NoSuchElementException;

class Lecture16 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 16");

        // Self-Check Problems:
        // Section 16.3: A Complex List Operation

        // 26. What are the four cases examined in the addSorted method?   Done!
        // Empty List: If the list is empty, the new element becomes the first (and only) element in the list.
        //New Element is Smaller than the First Element: If the new element is smaller than the first element of the list,
        // it should be inserted at the beginning.
        //New Element is Greater than the Last Element: If the new element is greater than the last element in the list,
        // it should be appended to the end of the list.
        //New Element Belongs in the Middle:The new element needs to be inserted somewhere in the middle of the list.
        // This case involves iterating through the list to find the correct insertion point,
        // ensuring that the sorted order is maintained.


        // 27. What is the “inchworm approach”?     Done!
        // What advantages does this approach have over other approaches for examining a
        // linked list?

        // The "inchworm approach" is a term used to describe a systematic and incremental method for solving problems or completing tasks.
        // It involves moving forward in small, manageable steps, similar to how an inchworm moves.
        //                                                      Advanteges
        // Simplicity and Clarity: The approach is straightforward, making it easy to understand and implement.
        // By moving through the list one element at a time, the logic remains simple and intuitive.
        //Efficiency: The inchworm approach ensures that each element is examined exactly once,
        // leading to an efficient O(n) time complexity for insertion in a singly linked list.
        // This linear time complexity is optimal for operations that involve sequential access,
        // such as finding the correct insertion point.

        // 28. Write methods called sum and average that return the sum of all values in   Done!
        // the list and the average value as a real number, respectively.
        // For example, if a variable called list stores [11, –7, 3, 42, 0, 14], the
        // call of list.sum() should return 63 and the call of list.average() should
        // return 10.5. If the list is empty, sum should return 0 and average should
        // return 0.0.

//        Integer [] a = {11, -7, 3, 42, 0, 14};
//        linked_list<Integer> list = new linked_list<>();
//        for (Integer n : a ){
//            list.add(n);
//        }
//        System.out.println(list);
//        System.out.println(list.sum());
//        System.out.println(list.average());
        // Section 16.4: An IntList Interface

        // 29. What are some advantages of creating an IntList interface and having both   Done!
        // types of lists implement it?


        // By defining an interface, you abstract away the details of the list implementations.
        // Users of the IntList interface don't need to know whether the list is implemented as a linked list,
        // an array list, or any other data structure. They only need to know the methods provided by the interface.
        // Implementation details are hidden behind the interface.
        // This allows the internal structure of the list to change without affecting code that relies on the interface.

        // 30. Write a method called firstLast that can accept either type of integer    Done!
        // list as a parameter and that moves the first element of the list to the end.
        // For example, if a variable called list contains the values [12, 45, 78, 20,
        // 36], the call of firstLast(list); will change the list to store [45, 78, 20,
        // 36, 12].
        Integer [] array = {12, 45, 78, 20, 36};
        linked_list<Integer> second = new linked_list<>();
        for (Integer n : array){
            second.add(n);
        }
//        second.firstLast();
//        System.out.println(second);

        // Section 16.5: LinkedList<E>

        // 31. What are some changes that need to be made to the linked list class to    Done!
        // convert it from storing integers to storing objects of type E?

        // To convert the linked list class from storing integers to storing generic objects of type E,
        // you need to ensure the class is properly parameterized with a generic type.
        // Use the generic type parameter E or T throughout the class instead of specific types like Integer.
        //Node Class: Ensure that the Node class is also parameterized with the generic type E.
        // I used it in my code.

        // 32. Why is an iterator especially useful with linked lists?    Done!

        // Using an iterator abstracts the traversal logic, making it simpler and more consistent.
        // Instead of managing node references and loop conditions manually,
        // an iterator provides a standard way to access each element sequentially.
        // An iterator also encapsulates the internal structure of the linked list.
        // Users of the iterator do not need to know how the linked list is implemented,
        // which makes the code more modular and easier to maintain.

        // 33. What state does the linked list iterator store? How does the iterator    Done!
        // know if there are more elements left to examine?

        // The linked list iterator typically stores the current position in the linked list and uses
        // this state to traverse the list and determine if there are more elements left to examine.
        //  The iterator maintains a reference to the current node in the linked list.
        //  This is used to track where the iterator is currently positioned within the list.
        // The hasNext method checks if there are more elements left in the list to examine.
        // It typically checks if the current node reference is not null. If it is not null, it means there are more elements to iterate over.
        // The next method returns the current element and advances the iterator to the next node.

        // Exercises:

        // 18. Write a method called doubleList that doubles the size of a list by    Done!
        // appending a copy of the original sequence to the end of the list.

        // For example, if a variable list stores the values [1, 3, 2, 7] and we make
        // the call of list.doubleList(); then after the call it should store [1, 3, 2,
        // 7, 1, 3, 2, 7]. Notice that the list has been doubled in size by having the
        // original sequence appear twice in a row. You may not make assumptions about
        // how many elements are in the list. You may not call any methods of the class
        // to solve this problem. If the original list contains N nodes, then you should
        // construct exactly N nodes to be added. You may not use any auxiliary data
        // structures such as arrays or ArrayLists to solve this problem. Your method
        // should run in O(N) time where N is the number of nodes in the list.

//        second.doubleList();
//        System.out.println(second);

        // 19. Write a method called rotate that moves the value at the front of a list    Done!
        // of integers to the end of the list.

        // For example, if a variable called list stores the values [8, 23, 19, 7, 45,
        // 98, 102, 4], then the call of list.rotate(); should move the value 8 from the
        // front of the list to the back of the list, changing the list to store [23,
        // 19, 7, 45, 98, 102, 4, 8]. If the method is called for a list of 0 elements
        // or 1 element, it should have no effect on the list. You may neither construct
        // any new nodes to solve this problem nor change any of the data values stored
        // in the nodes. You must solve the problem by rearranging the links of the
        // list.

        // I did it already.
        // It is firstlast method that does the same thing.
//        System.out.println(second);
//        second.firstLast();
//        System.out.println(second);

        // 21.  Write a method called surroundWith that takes an integer x and an    Done!
        // integer y as parameters and surrounds all nodes in the list containing the
        // value x with new nodes containing the value y.

        // In particular, each node that contains the value x as data should have a new
        // node just before it and just after it that each contain the value y. If no
        // nodes in the list contain the value x, then the list should not be modified.
        // For example, suppose that the variables list1, list2, and list3 store the
        // following sequences of values:

        // [0, 1, 2, 1]    // stored in list1
        // [0, 1, 0]       // stored in list2
        // [0, 1, 2]       // stored in list3



        // and we make the following calls:

        // list1.surroundWith(1, 4);   // surround 1s with 4s
        // list2.surroundWith(1, 1);   // surround 1s with 1s
        // list3.surroundWith(3, 4);   // surround 3s with 4s

        // then the variables will now store these sequences:

        // [0, 4, 1, 4, 2, 4, 1, 4]    // stored in list1
        // [0, 1, 1, 1, 0]             // stored in list2
        // [0, 1, 2]                   // stored in list3

        Integer [] c = {0,1,2,1};
        linked_list<Integer> third = new linked_list<>();
        for (Integer n : c){
            third.add(n);
        }
//        third.surroundWith(1,4);
//        System.out.println(third);

        // 22. Write a method called reverse that reverses the order of the elements in    Done!
        // the list.
        // (This is very challenging!) For example, if the variable list initially
        // stores the values [1, 8, 19, 4, 17], the call of list.reverse(); should
        // change the list to store [17, 4, 19, 8, 1].
//        System.out.println(third);
//        third.reverse();
//        System.out.println(third);
    }


//    public static void Firstlast(List<Integer> list){
//
//        int first_index = 0;
//        int last_index = list.size()-1;
//        int first = list.indexOf(first_index);
//        int last = list.indexOf(last_index);
//        int middle = (last_index + 1)/2;
//
//        while (first_index>=middle || last_index<=middle){
//
//        }
//    }

}
class Node <T>{
    T value;
    Node<T> next;
    public Node(T value){
        this.value = value;
        this.next = null;
    }
    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }
    public Node(){
        this.next = null;
    }
}class linked_list <T> implements Iterable<T> {
    Node<T> head;
    public linked_list(){
        this.head = null;
    }
    public void add(T value){
        Node<T> newNode = new Node<>(value);
        if (head==null){
            head = newNode;
        }
        else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public int sum(){
        int out =0;
        Node <T> current = head;
        while (current!=null){
            if (current.value instanceof Integer){
                out+= (Integer) current.value;
            } else if (current.value instanceof Double) {
                out+= (Double) current.value;
            } else {
                System.err.println("it should be an integer/Double");
                return 0;
            }
            current = current.next;
        }
        return out;
    }
    public double average(){
        double out = 0.0;
        int count=0;
        Node <T> current = head;
        while (current!=null){
            if (current.value instanceof Integer){
                out+= (Integer) current.value;
                count++;
            } else if (current.value instanceof Double) {
                out+= (Double) current.value;
                count++;
            }
            else {
                System.err.println("it should be an integer/Double");
                return 0;
            }
            current = current.next;
        }
        out = out/count;
        return out;
    }
    public void firstLast() {
        if (head == null || head.next == null) {
            return;
        }

        Node<T> first = head;
        head = head.next;

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = first;
        first.next = null;
    }
    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }
    public void doubleList() {
        if (head == null) {
            return;
        }

        Node<T> current = head;
        Node<T> tail = null;
        Node<T> newHead = null;
        Node<T> newTail = null;
        while (current != null) {
            Node<T> newNode = new Node<>(current.value);
            if (newHead == null) {
                newHead = newNode;
                newTail = newNode;
            } else {
                newTail.next = newNode;
                newTail = newNode;
            }
            current = current.next;
        }
        current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newHead;
    }
    public void surroundWith(T x, T y) {
        if (head == null) {
            return;
        }

        Node<T> first = new Node<>(null, head);
        Node<T> prev = first;
        Node<T> current = head;

        while (current != null) {
            if (current.value.equals(x)) {
                Node<T> before = new Node<>(y);
                prev.next = before;
                before.next = current;

                Node<T> after = new Node<>(y, current.next);
                current.next = after;
                prev = after;
                current = after.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        head = first.next;
    }
    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev; // Update head to be the last node encountered
    }
    private class LinkedListIterator implements Iterator<T>{
        private Node<T> current = head;
        @Override
        public boolean hasNext(){
            return current !=null;
        }
        @Override
        public T next(){
            if (!hasNext()){
                throw new NoSuchElementException("wrong");
            }
            T value = current.value;
            current = current.next;
            return value;
        }

    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("[");
        Node<T> current2 = head;
        while (current2 != null) {
            out.append(current2.value);
            if (current2.next != null) {
                out.append(", ");
            }
            current2 = current2.next;
        }
        out.append("]");
        return out.toString();
    }
}

