import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Lecture12 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 12");

        // Self-Check Problems: Done!
        // Section 14.1: Stack/Queue Basics

        // 1. Which of the following statements about stacks and queues is true?  Done!

        // A. Stacks and queues can store only integers as their data.
        // B. A stack returns elements in the same order as they were added (first-in,
        // first-out).
        // C. A queue’s remove method removes and returns the element at the front of
        // the
        // queue.
        // D. Stacks and queues are similar to lists, but less efficient.
        // E. The peek method allows access to the element at the bottom of a stack.

        // (C) A queue’s remove method removes and returns the element at the front of the queue (C)

        // 2.  What is a real-world example of data that could be modeled using a stack? Done!
        // Using a queue?
        // Stacks: Web Browser History: When you navigate through web pages in a browser,
        // each page you visit is pushed onto a stack. If you click the back button,
        // the current page is popped off the stack, returning you to the previous page.
        // This allows you to navigate back through your browsing history in a
        // Last In, First Out (LIFO) manner.

        // Queue: Text editors often implement an undo feature using a stack.
        // Every action (e.g., typing, deleting, formatting) you perform is recorded as
        // a command and pushed onto the stack. When you undo an action,
        // the most recent command is popped off the stack, reverting the document to its previous state.

        // 3. When you call push on a stack, where is the new element placed relative to Done!
        // the other elements in the stack?
        // When you call pop, which element from the stack is returned?

        // When you use push on a stack:
        // The new element is placed on top of the stack.
        // This means that it becomes the topmost element in the stack,
        // and any subsequent pop operation will return this newly added element first.

        // When you call pop on a stack:
        // The element returned is the topmost element of the stack.
        //This element is removed from the stack, and subsequent pop operations will return the element
        // that was below it in the stack, following the Last In, First Out (LIFO) principle.

        // 4. When you call add on a queue, where is the new element placed relative to   Done!
        // the other elements in the queue?
        // When you call remove, which element from the queue is returned?

        // When you call add on a queue:
        // The new element is added to the end (rear) of the queue.
        // This means that it joins the queue after all the existing elements, following the First In, First Out (FIFO) principle.

        // When you call remove (or poll) on a queue:
        //The element returned is the one at the front (head) of the queue.
        //This element is removed from the queue, and subsequent remove operations \
        // will return the element that was added to the queue after the one just removed, following the FIFO principle.

        // 5. If you create a new empty stack and push the values 1, 2, and 3 in that Done!
        // order, and call pop on the stack once, what value will be returned?

        // Call pop on the stack once. This removes and returns the topmost element, which is 3.


        // 6. If you create a new empty queue and add the values 1, 2, and 3 in that Done!
        // order, and call remove on the queue once, what value will be returned?

        // Call remove (or poll) on the queue once. This removes and returns the element at the front of the queue, which is 1.



        // Section 14.2: Common Stack/Queue Operations

        // 12. Stacks and queues have less functionality than other similar collections Done!
        // like lists and maps.
        // Why are they still useful despite lacking functionality? What possible
        // advantages are there of using a less powerful collection?
        // Stacks and queues are simpler data structures with well-defined behaviors
        // (LIFO for stacks and FIFO for queues). This simplicity makes them easier
        // to understand, implement, and use in certain situations where their specific behaviors are sufficient.

        //  Stacks and queues often provide more efficient operations for their intended use cases compared
        //  to more complex collections like lists and maps. For example,
        //  push and pop operations on a stack and offer and poll operations on a queue
        //  typically have constant time complexity (O(1)), making them efficient for certain types of operations.



        // 13. What is the output of the following code? Done!
        // Do this by hand to make sure that you understand stacks and queues

        // [you, are, how]

        // 14. What is the output of the following code? Done!
        // Do this by hand to make sure that you understand stacks and queues

        //      10
        //      7
        //      5
        //      false
        //      2
        //      3
        //      8
        //      3

        // 22. Write a piece of code that prints the elements of a queue of integers, Done!
        // one per line.
        // When your code is done running, the queue should still contain the same
        // contents as it had at the start. In other words, don’t destroy the queue as
        // you print it. If you like, put your code into a method called print that
        // accepts the queue as a parameter.

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            queue.add(i);
        }
//        print_queue(queue); //  Just uncomment and run this

        // 23. Write a piece of code that finds and prints the longest string in a stack Done!
        // of strings.

        // For example, in the stack [hello, hi, goodbye, howdy], the longest string is
        // "goodbye". When your code is done running, the stack should still contain the
        // same contents as it had at the start. In other words, if you destroy the
        // stack as you examine it, restore its state afterward. If you like, put your
        // code into a method called printLongest that accepts the stack as a parameter.
        Stack<String> stack = new Stack<>();
        stack.add("Hello");
        stack.add("Hi");
        stack.add("goodbye");
        stack.add("howdy");
//        find_longest(stack);    // Just uncomment and run this

        // Exercises:

        // None

    }

    public static void print_queue(Queue<Integer> queue){
        Queue<Integer> second = new LinkedList<>(queue);
        for (int i = 0; i < second.size(); i++) {
            int a = second.poll();
            System.out.println(a);
            second.add(a);
        }
        System.out.println(queue);
    }
    public static void find_longest(Stack<String> stack){
        Stack<String> temp_stack = new Stack<>();
        temp_stack.addAll(stack);
        String longest = "";
        while (!temp_stack.isEmpty()){
            String current = temp_stack.pop();
            if (longest.length()<current.length()){
                longest = current;

            }
        }
        System.out.println("Longest is: "+ longest);
        stack.addAll(temp_stack);
        System.out.println(stack);

    }
}
