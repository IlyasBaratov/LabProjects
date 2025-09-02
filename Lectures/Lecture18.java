class Lecture18 {
    public static void main(String[] args) {
        System.out.println("Hello from lecture 18");

        // SELF-CHECK PROBLEMS:
        // Note: you may need to put some of your answers inside comments

        // Put your answer for #26 here:    Done!
        /* To convert a tree class that stores integers to store any type (generic type E), we need to:
            Change the Class Declaration: Make your tree and node classes generic by using <E>;
            Update Field Types: Change the data type in the nodes from int to E.
            Modify Methods: Update all methods to work with the generic type E instead of int.
            Ensure Comparability: Make sure the type E can be compared, either by making E implement Comparable<E> or by using a Comparator<E>.
        */

        // Put your answer for #27 here:  Done!

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
        IntTree tree1 = new IntTree(3);
        tree1.root.left = new IntTreeNode(4);
        tree1.root.right = new IntTreeNode(7);
        tree1.root.left.left = new IntTreeNode(0);
        tree1.root.left.right = new IntTreeNode(9);
        tree1.root.right.right = new IntTreeNode(2);
        tree1.root.left.right.left = new IntTreeNode(8);

        IntTree tree2 = new IntTree(3);
        tree2.root.left = new IntTreeNode(6);
        tree2.root.right = new IntTreeNode(7);
        tree2.root.left.left = new IntTreeNode(0);
        tree2.root.left.left.left = new IntTreeNode(8);
        tree2.root.right.left = new IntTreeNode(9);
        tree2.root.right.right = new IntTreeNode(2);


        int count = tree1.matches(tree1.root, tree2.root);
        System.out.println("Count is: " + count);


    }


    static class IntTreeNode{
        int data;
        IntTreeNode left;
        IntTreeNode right;
        public IntTreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public IntTreeNode (int data, IntTreeNode left, IntTreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static class IntTree{
        public IntTreeNode root;
        public IntTree(){
            this.root = null;
        }
        public IntTree(int value){this.root = new IntTreeNode(value);}
        public void add(int value){
            root = add(root, value);
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
        public int matches(IntTreeNode node1, IntTreeNode node2){
            int out=0;
            if (node1 == null || node2 == null){
                return 0;
            }
            if (node1.data == node2.data){
                out = 1;
            }
            return out + matches(node1.left,node2.left) + matches(node1.right,node2.right);
        }



    }
}
