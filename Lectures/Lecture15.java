
class Lecture15 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 15");

        // NOTE NOTE NOTE
        // Several problems ask you to draw pictures / images. Here are some ideas for
        // how to do that:
        //
        // Some ideas for how to draw the images:
        // * Draw this out on paper, snap a picture with your phone
        //
        // * Capture a screenshot and then draw on it using MS Paint or MacOS Image
        // Preview, etc
        // (You'll need to Google for how to take the screenshot - it's not hard once
        // you know how, it's just well-hidden)
        //
        // * Use diagram-making software. You can find free online websites that let you
        // do this on the website
        //
        // * If you find other ways please do share! Especially if they're quick and
        // easy! :)

        //
        //
        // Some ideas for how to add the images to this repo:
        //
        // * Add the image files directly to the repo (in which case please name the
        // files
        // Question 5.png, or Answer 6.gif, or 7.jpeg, or whatever)
        //
        // * Embedding them in a Word /.DOC/.DOCX file
        //
        // * Embed them into a .PDF file (this is good for MacOS people - you can create
        // a .pages file, then export to .PDF)
        // (I can't open .pages files reliably on Windows)

        //
        // DO NOT DO THE FOLLOWING:
        //
        // * Do NOT upload to Google Drive / Dropbox / etc and then hand in a link.
        // I want to have copies of the work that you've done even after the quarter
        // ends

        //
        //
        //
        // Self-Check Problems:
        // Section 16.1: Working with Nodes

        // 1. What is the difference between a linked list and an array list? How are    Done!
        // they are similar?

        // Arraylist --> Uses a dynamic array (a resizable array) to store its elements.
        // When the array's capacity is exceeded, it creates a new larger array and copies the elements over.
        // Linked list --> Uses a doubly linked list where each element (node)
        // contains a reference to the previous and next node in the sequence.

        // 2. What is the difference between a linked node and a linked list? How are    Done!
        // they related and connected?

        // A linked node is an individual element of a linked list. Each node contains two parts:
        //Value/ Data, and the Next Pointer
        // A linked list is a collection of linked nodes arranged in a linear order.
        // It is a dynamic data structure that allows for efficient insertion and deletion of elements.

        // 3. What value is stored as the next field of the last node of a list? What    Done!
        // value will a node’s next field have if none is specified?
        // In a linked list, the next field of the last node is set to null.
        // This null value signifies the end of the list, indicating that there are no further nodes after this one.

        // 4. What happens if you or the client tries to go past the last element in a    Done!
        // linked list? Be specific.
        // If you try to traverse past the last element in a linked list,
        // you will encounter a null value, which signifies the end of the list.
        // When traversing a linked list, each node's next field points to the next node in the sequence.
        // The traversal continues until a node's next field is null, indicating that the node is the last in the list.
        // QUESTIONS 5- 17:
        // Please put these into a separate file(s), as described in this file above

        // Section 16.2: A Linked List Class
        // 18. What are the two ways to change the contents of a linked list?    Done!

        /*
            The two main ways to change the contents of a linked list are:

            Insertion:

            Adding a Node: You can insert a new node into the linked list at various positions (beginning, middle, or end).
            Example: Adding a new node with value 3 after the head node.
            ListNode newNode = new ListNode(3);
            newNode.next = head.next;
            head.next = newNode;
            Deletion:
            Removing a Node: You can remove an existing node from the linked list.
            Example: Removing the second node from the list.
            head.next = head.next.next;


        */

        // 19. An element can be inserted at or removed from the beginning, middle, or    Done!
        // end of a linked list.
        // Which of the three locations is the most computationally expensive, and why?
        // How does this compare against the result for an array list?

        /*
            Linked List:
            Most Expensive: Middle operations (O(n) due to traversal).
            Array List:
            Most Expensive: Beginning and middle operations (O(n) due to shifting elements).
            Comparison:
            Linked List: Better for beginning and end operations.
            Array List: Better for end operations.

        */

        // 20. When you add or remove the element found at index i of a list, you must    Done!
        // create a temporary current node reference and advance it through the list.
        // At which index’s node should the loop stop, relative to i?

        /*
            When adding or removing an element at index i of a linked list, the loop should stop at the node just before the target index i.

            For Addition:
            Stop at: Index i−1
            Reason: You need to modify the next reference of the node at index i−1 to point to the new node.
            For Removal:
            Stop at: Index    i−1
            Reason: You need to modify the next reference of the node at index i−1 to skip the node at index i.
            Example:
            For an index i=3:
                Loop stops at: Index 2

            Code Snippet for Insertion:
            ListNode current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            // current is now at index i - 1
            ListNode newNode = new ListNode(newValue);
            newNode.next = current.next;
            current.next = newNode;

            Code Snippet for Removal:
            ListNode current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            // current is now at index i - 1
            current.next = current.next.next;
        */

        // 21. In an array list, it is possible to overrun the capacity of the array, at    Done!
        // which point the list must be resized to fit.
        // Is resizing necessary on a linked list? What limits the number of elements
        // that a linked list can have?


        // Resizing in Linked List: Not necessary. A linked list grows dynamically as nodes are added.
        //            Limits on Elements: Only limited by available memory.

        // QUESTIONS 21-24:
        // Please put these into a separate file(s), as described in this file above

        // Exercises:
        // None

    }
}
