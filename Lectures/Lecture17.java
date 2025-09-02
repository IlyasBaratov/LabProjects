import java.util.NoSuchElementException;

class Lecture17 {
    public static void main(String[] args) {
        // 29 41 6 17 81 9 40   subtree
        System.out.println("Hello from lecture 17");

        // Self-Check Problems:
        // Section 17.2: Tree Traversals


        // 9. Write a method called printMirror that could be added to the IntTree class    Done!
        // and that prints a backward inorder traversal of the tree.
        // That is, for a given node, it examines the right subtree, then the node
        // itself, then the left subtree.


//        IntTreeNode node1 = new IntTreeNode(1);
//        IntTreeNode node3 = new IntTreeNode(3);
//        IntTreeNode node2 = new IntTreeNode(2, node1, node3);
//        IntTreeNode node5 = new IntTreeNode(5);
//        IntTreeNode node4 = new IntTreeNode(4, node2, node5);
        IntTree tree = new IntTree();
        tree.add(6);
        tree.add(81);
        tree.add(40);
        tree.add(29);
        tree.add(41);
        tree.add(17);
        tree.add(9);



//        System.out.println("Overall root");
//        tree.inOrder_backwards();
//        System.out.println();


        // Section 17.3: Common Tree Operations

        // 10. Why do many recursive tree methods use a public/private pair?    Done!
        // What is the difference between the header of the public method and that of
        // the private method?

        // The public method provides a simple interface to the users of the class.
        // Users do not need to know the details of the recursion or the internal structure of the tree.
        // The private method handles the actual recursive logic. By keeping it private,
        // the implementation details are hidden from the users, promoting encapsulation.

        // 11. Write a method called size that could be added to the IntTree class and    Done!
        // that returns the total number of nodes in the tree.

//        System.out.println(tree.size());

        // 12. Write methods called min and max that could be added to the IntTree class    Done!
        // and that return the smallest and largest values in the tree, respectively.
        // For example, if a variable called tree stores the values shown in Self-Check
        // Problem 5, the call of tree.min() should return –2 and the call of tree.max()
        // should return 94. If the tree is empty, the methods should throw an
        // IllegalStateException.

//        System.out.println("max is: "+tree.max());
//        System.out.println("min is: "+tree.min());


        // Section 17.4: Binary Search Trees

        // 14. What is the difference between a regular binary tree and a binary search    Done!
        // tree?

        /*
            Difference Between a Regular Binary Tree and a Binary Search Tree
            Regular Binary Tree: A tree where each node has at most two children, but there are no specific rules about the node values.
            Binary Search Tree (BST): A binary tree where each node follows these rules:
            Left child values are less than the node's value.
            Right child values are greater than the node's value.
        */

        // 16.  What will be true about the results of an inorder traversal of a binary    Done!
        // search tree?

        /*
            Inorder Traversal of a Binary Search Tree
            Inorder Traversal of a BST: Visits nodes in the order: left subtree, node, right subtree.
            Result: Produces values in ascending sorted order.
        */

        // For each of the next four problems, draw the binary search tree that would
        // result if the given elements were added to an empty binary search tree in the
        // given order. Then write the elements of the tree in the order that they would
        // be visited by each kind of traversal (preorder, inorder, and postorder).

        // 17. Leia, Boba, Darth, R2D2, Han, Luke, Chewy, Jabba
                          /*
                          *               Leia
                          *               /  \
                          *           Boba      R2D2
                          *            \         /
                          *           Dart    Luke
                          *           /  \
                          *     Chewy     Han
                          *                \
                          *                 jebba
                          *

        Tree Traversals:
        Preorder (Root, Left, Right):
        Leia, Boba, Chewy, Darth, R2D2, Han, Luke, Jabba
        Inorder (Left, Root, Right):
        Chewy, Boba, Darth, Leia, Han, R2D2, Jabba, Luke
        Postorder (Left, Right, Root):
        Chewy, Darth, Boba, Han, Jabba, Luke, R2D2, Leia
                                   */

        // 18. Meg, Stewie, Peter, Joe, Lois, Brian, Quagmire, Cleveland

        /*
                         Meg
                        /   \
                       Joe   Stewie
                       /    /    \
                    Brian Lois   Peter
                        \            \
                    Cleveland     Quagmire

            Tree Traversals:
            Preorder (Root, Left, Right):
            Meg, Joe, Brian, Cleveland, Stewie, Peter, Lois, Quagmire
            Inorder (Left, Root, Right):
            Brian, Cleveland, Joe, Lois, Meg, Peter, Quagmire, Stewie
            Postorder (Left, Right, Root):
            Cleveland, Brian, Lois, Joe, Quagmire, Peter, Stewie, Meg

        */



        // 19. Kirk, Spock, Scotty, McCoy, Chekov, Uhuru, Sulu, Khaaaan!


        /*
                         Kirk
                        /    \
                        Chekov Spock
                        \   /
                        Khaaaan! Scotty
                                /    \
                            McCoy  Uhuru
                                    /
                                    Sulu

            Tree Traversals:
            Preorder (Root, Left, Right):
            Kirk, Chekov, Khaaaan!, Spock, Scotty, McCoy, Uhuru, Sulu
            Inorder (Left, Root, Right):
            Chekov, Khaaaan!, Kirk, McCoy, Scotty, Sulu, Uhuru, Spock
            Postorder (Left, Right, Root):
            Khaaaan!, Chekov, McCoy, Sulu, Uhuru, Scotty, Spock, Kirk

        */

        // 20. Lisa, Bart, Marge, Homer, Maggie, Flanders, Smithers, Milhouse


        /*
                         Lisa
                        /    \
                      Bart  Marge
                        \   /   \
                     Homer Maggie Smithers
                       \       /
                    Flanders Milhouse

             Tree Traversals:
            Preorder (Root, Left, Right):
            Lisa, Bart, Homer, Flanders, Marge, Maggie, Smithers, Milhouse
            Inorder (Left, Root, Right):
            Bart, Flanders, Homer, Lisa, Maggie, Marge, Milhouse, Smithers
            Postorder (Left, Right, Root):
            Flanders, Homer, Bart, Maggie, Milhouse, Smithers, Marge, Lisa

        */

        // 22. What is the x = change(x) pattern, and how is it used with binary trees?   Done!

        /*
            x = change(x) Pattern in Binary Trees:
            Pattern:
            x = change(x) means reassigning the result of a recursive function to ensure changes are updated.

            Purpose:
            Ensures tree modifications (like adding, removing, or balancing nodes) are correctly reflected in the tree structure.

        */

        // 23. How many nodes at most would be examined in a call to contains on a    Done!
        // perfect binary search tree of height N?

        /*
            In a perfect binary search tree of height   N:

            Number of Nodes Examined: At most  N+1 nodes.
            Reason:
                In each level, you check one node and move either left or right.
                There are N levels, plus the root node.
            Summary:
                You check one node per level, resulting in N+1 nodes examined in total.

        */

        // 24. Consider the following implementation of the contains method.    Done!

        // How does it differ from the one we showed in Section 17.4? Is it better or
        // worse, and why?

        // private boolean contains(IntTreeNode root, int value) {
        //     if (root == null) {
        //         return false;
        //     } else if (value == root.data) {
        //         return true;
        //     } else {
        //         return contains(root.left, value) || contains(root.right, value);
        //     }
        // }



        /*
            Differences Between contains Methods:
            Traversal:

            Provided Method: Checks both left and right subtrees for every node.
            Typical BST Method: Checks only one subtree (left or right) based on the value.
            Efficiency:

            Provided Method: Takes longer, potentially checking all nodes (O(n)).
            Typical BST Method: Faster, checks fewer nodes by using tree properties (O(logn)).
            Suitability:

            Provided Method: Works for any binary tree.
            Typical BST Method: Specifically optimized for binary search trees.
            Conclusion:
            The typical BST method is better for binary search trees because it's faster and more efficient.
        */

        // 25. Rewrite the min and max methods from Self-Check Problem 12 so that they
        // will work on a binary search tree.
        // The methods should take advantage of the fact that the tree is sorted and
        // should not examine nodes unless necessary.

        /*
            min() Method:
            Public Method: min()
            Checks if the tree is empty and throws an exception if it is.
            Calls the private min(IntTreeNode root) method.
            Private Method: min(IntTreeNode root)
            Iteratively traverses the leftmost path of the tree to find the minimum value.
            Returns the data of the leftmost node.
            max() Method:

            Public Method: max()
            Checks if the tree is empty and throws an exception if it is.
            Calls the private max(IntTreeNode root) method.
            Private Method: max(IntTreeNode root)
            Iteratively traverses the rightmost path of the tree to find the maximum value.
            Returns the data of the rightmost node.

        */

        // Exercises:

        // None
    }


}

class IntTree{
    public IntTreeNode root;
    public IntTree(){
        this.root = null;
    }
    private IntTreeNode add(IntTreeNode node, int value){
        if (node == null){
            node = new IntTreeNode(value);
        } else if (value < node.data) {
            node.left = add(node.left, value);
        }
        else {
            node.right = add(node.right, value);
        }
        return node;
    }
    public void add(int value){
        root = add(root, value);
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(IntTreeNode node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(IntTreeNode node){
        if (node != null){
            System.out.print(node.data+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(IntTreeNode node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+" ");
        }
    }
    public void inOrder_backwards(){
        inOrder_backwards(root);
    }
    private void inOrder_backwards(IntTreeNode node){
        if (node != null){
            inOrder_backwards(node.right);
            System.out.print(node.data+" ");
            inOrder_backwards(node.left);
        }
    }
    public int size(){
        return size(root);
    }
    private int size(IntTreeNode node){
        if (node == null){
            return 0;
        }
        else {
            return 1 + size(node.left)+size(node.right);
        }
    }
    public int min(){
        if (root == null){
            throw new IllegalStateException("no such element");
        }
        else {
            return min(root);
        }
    }
    private int min(IntTreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }
    public int max(){
        if (root == null){
            throw new IllegalStateException("no such element");
        }
        else return max(root);
    }
    private int max(IntTreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }


}
class IntTreeNode{
    public int data;
    public IntTreeNode left;
    public IntTreeNode right;
    public IntTreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    public IntTreeNode(int data, IntTreeNode left, IntTreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
