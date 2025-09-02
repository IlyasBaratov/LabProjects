class Lecture17_from_Resul {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 17");

        // 9. Write a method called printMirror that could be added to the IntTree class
        IntTree_2 tree = new IntTree_2();
        tree.add(4);
        tree.add(2);
        tree.add(6);
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(7);

        System.out.println("Backward Inorder Traversal:");
        tree.printMirror();  // Should print: 7 6 5 4 3 2 1

        // 10. Why do many recursive tree methods use a public/private pair?
        /*
            Why Use a Public/Private Pair?
            Simplifies Use: The public method is easy for users to call.
            Handles Initialization: The public method sets up the recursion.
            Controls Parameters: The private method handles extra parameters needed for recursion.
            Differences Between Headers
            Public Method:

            Simple Interface: No extra parameters.
            Example: public void printMirror()
            Private Method:

            Handles Recursion: Takes extra parameters like the current node.
            Example: private void printMirror(IntTreeNode root)
        */

        // 11. Write a method called size that could be added to the IntTree class
        
        System.out.println("Size of the tree: " + tree.size());  // Should print: 7

        // 12. Write methods called min and max that could be added to the IntTree class
        
        System.out.println("Minimum value in the tree: " + tree.min());  // Should print the smallest value
        System.out.println("Maximum value in the tree: " + tree.max());  // Should print the largest value

        // Section 17.4: Binary Search Trees

        // 14. What is the difference between a regular binary tree and a binary search
        // tree?
        /*
            Difference Between a Regular Binary Tree and a Binary Search Tree
            Regular Binary Tree: A tree where each node has at most two children, but there are no specific rules about the node values.
            Binary Search Tree (BST): A binary tree where each node follows these rules:
            Left child values are less than the node's value.
            Right child values are greater than the node's value.
        */

        // 16.  What will be true about the results of an inorder traversal of a binary
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

        // 22. What is the x = change(x) pattern, and how is it used with binary trees?
        /*
            x = change(x) Pattern in Binary Trees:
            Pattern:
            x = change(x) means reassigning the result of a recursive function to ensure changes are updated.
            
            Purpose:
            Ensures tree modifications (like adding, removing, or balancing nodes) are correctly reflected in the tree structure.

        */

        // 23. How many nodes at most would be examined in a call to contains on a
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

        // 24. Consider the following implementation of the contains method.
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

        // 17. Leia, Boba, Darth, R2D2, Han, Luke, Chewy, Jabba
        /*
                 Leia
                /   \
                Boba  R2D2
                / \   /  \
            Chewy Darth Han Luke
                            /
                        Jabba
        
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
    }
}

// IntTree class with the printMirror, size, min, and max methods
class IntTree_2 {
    private IntTreeNode overallRoot;

    private static class IntTreeNode {
        public int data;
        public IntTreeNode left;
        public IntTreeNode right;

        public IntTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public IntTree_2() {
        overallRoot = null;
    }

    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value < root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public void printMirror() {
        printMirror(overallRoot);
    }

    private void printMirror(IntTreeNode root) {
        if (root != null) {
            printMirror(root.right);
            System.out.print(root.data + " ");
            printMirror(root.left);
        }
    }

    // Public method to get the size of the tree
    public int size() {
        return size(overallRoot); // Start the recursion from the root
    }

    // Private helper method to count nodes recursively
    private int size(IntTreeNode root) {
        if (root == null) {
            return 0; // Base case: no nodes in an empty subtree
        } else {
            // Recursive case: 1 (for the root) + size of left subtree + size of right subtree
            return 1 + size(root.left) + size(root.right);
        }
    }

    // Public method to get the minimum value in the tree
    public int min() {
        if (overallRoot == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return min(overallRoot);
    }

    // Private helper method to find the minimum value iteratively
    private int min(IntTreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // Public method to get the maximum value in the tree
    public int max() {
        if (overallRoot == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return max(overallRoot);
    }

    // Private helper method to find the maximum value iteratively
    private int max(IntTreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
