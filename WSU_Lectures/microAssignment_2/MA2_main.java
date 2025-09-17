package microAssignment_2;
/**
 * Simple driver for AVL tree testing.
 * Builds two trees to exercise both left-heavy and right-heavy insertion patterns
 * and prints their pre-order traversals.
 */
public class MA2_main {

	public static void main(String[] args) {
		leftTest();
		System.out.println();
		rightTest();
		System.out.println();
//        AvlTree<String> avlTree = new AvlTree<>();
//        String [] array = {"Leia", "Boba", "Darth", "R2D2", "Han", "Luke", "Chewy", "Jabba"};
//        for (String n : array){
//            avlTree.addElement(n);
//        }


	}

    /**
     * Inserts the integers 10 down to 1 (descending) to produce a left-heavy pattern
     * and then prints the pre-order traversal using {@link PreOrderTraversal}.
     * <p>
     * With a correct AVL implementation, the tree will rebalance to height O(log n).
     */
	public static void leftTest()
	{
		AvlTree<Integer> avl = new AvlTree<>();

        for (int i = 10; i > 0; i--) {
            avl.addElement(i);
        }

//		avl.addElement(10);
//		avl.addElement(9);
//		avl.addElement(8);
		
		System.out.println("AVL pre-order traversal: ");
		avl.traverse(new PreOrderTraversal<Integer>());	
		System.out.println();
	}

    /**
     * Inserts the integers 0 up to 9 (ascending) to produce a right-heavy pattern
     * and then prints the pre-order traversal using {@link PreOrderTraversal}.
     * <p>
     * With a correct AVL implementation, the tree will rebalance to height O(log n).
     */
	public static void rightTest()
	{
		AvlTree<Integer> avl = new AvlTree<>();
        for (int i = 0; i < 10; i++) {
            avl.addElement(i);
        }

//		avl.addElement(1);
//		avl.addElement(2);
//		avl.addElement(3);

		System.out.println("AVL pre-order traversal: ");
		avl.traverse(new PreOrderTraversal<Integer>());
		System.out.println();
	}

}
