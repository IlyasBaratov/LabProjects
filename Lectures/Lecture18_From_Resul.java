class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree_From_Resul {
    TreeNode root;

    BinaryTree_From_Resul(int value) {
        root = new TreeNode(value);
    }

    public int matches(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return 0;
        }
        if (node1 == null || node2 == null) {
            return 0;
        }
        int matchCount = 0;
        if (node1.value == node2.value) {
            matchCount = 1;
        }
        return matchCount + matches(node1.left, node2.left) + matches(node1.right, node2.right);
    }
}

public class Lecture18_From_Resul {

    public static void main(String[] args) {
        System.out.println("Hello from lecture 18");
        // Put your answer for #26 here:
        /*
            To convert a tree class that stores integers to store any type (generic type E), we need to:
            Change the Class Declaration: Make your tree and node classes generic by using <E>;
            Update Field Types: Change the data type in the nodes from int to E.
            Modify Methods: Update all methods to work with the generic type E instead of int.
            Ensure Comparability: Make sure the type E can be compared, either by making E implement Comparable<E> or by using a Comparator<E>.
        */
        // Put your answer for #27 here:
        /*
            To add an iterator to a binary tree class, we can do the following:

            1. **Implement Iterable**: Make the binary tree class implement the `Iterable<E>` interface.
            2. **Define Iterator**: Create an inner class that implements the `Iterator<E>` interface.
            3. **Traversal Method**: Decide on a traversal method (e.g., in-order, pre-order, post-order) and use it in the iterator to navigate through the tree.
            4. **Iterator Methods**: Implement the `hasNext()` and `next()` methods in the iterator class to handle the traversal and return nodes' values.

            By following these steps, we allow our binary tree to be used in enhanced for-loops and other features that utilize iterators.
        */

        // EXERCISES:

        // Put your answer for #21 here:
        
        // Creating the first tree
        BinaryTree_From_Resul tree1 = new BinaryTree_From_Resul(3);
        tree1.root.left = new TreeNode(4);
        tree1.root.right = new TreeNode(7);
        tree1.root.left.left = new TreeNode(0);
        tree1.root.left.right = new TreeNode(9);
        tree1.root.right.right = new TreeNode(2);
        tree1.root.left.right.left = new TreeNode(8);

        // Creating the second tree
        BinaryTree_From_Resul tree2 = new BinaryTree_From_Resul(3);
        tree2.root.left = new TreeNode(6);
        tree2.root.right = new TreeNode(7);
        tree2.root.left.left = new TreeNode(0);
        tree2.root.left.left.left = new TreeNode(8);
        tree2.root.right.left = new TreeNode(9);
        tree2.root.right.right = new TreeNode(2);

        int matchCount = tree1.matches(tree1.root, tree2.root);
        System.out.println("Number of matching nodes: " + matchCount); // Output 4
    }
}
