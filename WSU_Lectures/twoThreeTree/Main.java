package twoThreeTree;

public class Main {
    public static void main(String[] args) {
        TwoThreeTree<Integer> tree = new TwoThreeTree<>();
        int [] nums = {7, 3, 9, 1, 5, 8, 10, 2, 4, 6};
        for ( int n : nums) tree.insert(n);

        System.out.println("InOrder after inserts: " + tree.inOrder());
        System.out.println("Contains 5? " + tree.contains(5));
        System.out.println("Contains 11? " + tree.contains(11));

        tree.remove(1);
        tree.remove(5);
        tree.remove(9);

        System.out.println("InOrdewr after deletion (1,5,9): " + tree.inOrder());

        // Attempt deleting non-existent:
//        System.out.println("Deleting 43 --> " + tree.remove(43));
    }
}
