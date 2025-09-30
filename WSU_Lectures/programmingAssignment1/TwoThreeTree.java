package programmingAssignment1;

import twoThreeTree.Split;

import java.util.Objects;

/**
 * The 2-3 Tree class
 * @author ____
 */
public class TwoThreeTree<E extends Comparable<E>> {

    // the root of the tree
    private TwoThreeNode<E> root;

    /**
     * The constructor of the 2-3 Tree
     */
    public TwoThreeTree() {
        root = null;
    }

    /**
     * The in-order traversal of the 2-3 Tree
     * @return the String representation of in-order data
     */
    public String inorder() {
        String s = inorder(root);
        return s;
    }

    // The helper method for in-order traversal of the 2-3 Tree
    private String inorder(TwoThreeNode<E> r) {
        String s = "";
        if (r == null)
            return "";
        else
            if (r.leaf) {
                s = s + "key1: " + String.valueOf(r.key1) + " ";
                if (r.key2 != null)
                    s = s + "key2: " + String.valueOf(r.key2) + " ";
            }
            else {
                s = s + inorder(r.lc);
                s = s + "key1: " + String.valueOf(r.key1) + " ";
                s = s + inorder(r.mc);

                if (r.key2 != null) {
                    s = s + "key2: " + String.valueOf(r.key2) + " ";
                    s = s + inorder(r.rc);
                }
            }

        return s;
    }

    /**
     * The search method
     * @param key the data to be searched in the tree
     */
    public boolean contains(E key) {
        // TO BE IMPLEMENTED
        // placeholder code
        return containsHelp(key);
    }
    private boolean containsHelp(E key){
        Objects.requireNonNull(key,"key");
        TwoThreeNode<E> node = root;
        while (node != null){
            if (equal(key, node.key1)) return true;
            if (node.key2 != null && equal(key, node.key2)) return true;

            if (less(key, node.key1)) {
                node = node.lc;
            } else if (node.key2 == null) {          // 2-node
                node = node.rc;                      // key >= key1
            } else if (less(key, node.key2)) {       // key1 <= key < key2
                node = node.mc;                      // MUST be mc (bug before)
            } else {
                node = node.rc;                      // key >= key2
            }
        }
        return false;
    }

    /**
     * The data insertion method for the 2-3 Tree
     * @param key the data to be inserted
     */
    public void insert(E key) {
        // TO BE IMPLEMENTED
        // placeholder code
        Objects.requireNonNull(key,"key");
        if (root == null){
            root = new TwoThreeNode<E>(key);
            return;
        }
        if (contains(key)) return;
        Split<E> res = recursion(root, key);
        if (res != null){
            TwoThreeNode<E> newRoot = new TwoThreeNode<>();
            newRoot.leaf = false;
            newRoot.key1 = res.middle;
            newRoot.lc = res.left;
            newRoot.rc = res.right;
            root = newRoot;
        }


    }

    private Split<E> recursion(TwoThreeNode<E> node, E key){
        if (node.leaf) {
            return insertIntoLeaf(node, key);
        }
        int index; TwoThreeNode<E> child;
        if (less(key, node.key1)) {
            index = 0; child = node.lc;
        } else if (node.key2 == null) {
            index = 1; child = node.rc;
        } else if (less(key, node.key2)) {
            index = 1; child = node.mc;
        } else {
            index = 2; child = node.rc;
        }

        Split<E> split = recursion(child, key);
        if (split == null) return null;

        if (node.key2 == null) {
            if (index == 0) {
                node.key2 = node.key1;
                node.key1 = split.middle;
                node.mc   = node.rc;
                node.lc   = split.left;
                node.rc   = split.right;
            } else { // index == 1
                node.key2 = split.middle;
                node.mc   = split.left;
                node.rc   = split.right;
            }
            return null;
        }
        return splitParentNode(node, split, index);
    }





    private Split<E> splitParentNode(TwoThreeNode<E> node, Split<E> splitChild, int index){

        E key1 = node.key1;
        E key2 = node.key2;

        E k0, k1, k2;
        TwoThreeNode<E> c0,c1,c2,c3;
        if (index == 0){
            k0 = splitChild.middle; k1 = key1; k2 = key2;
            c0 = splitChild.left; c1 = splitChild.right;
            c2 = node.mc; c3 = node.rc;
        } else if (index == 1) {
            k0 = node.key1; k1 = splitChild.middle; k2 = node.key2;
            c0 = node.lc; c1 = splitChild.left;
            c2 = splitChild.right; c3 = node.rc;
        }
        else {
            k0 = node.key1; k1 = node.key2; k2 = splitChild.middle;
            c0 = node.lc; c1 = node.mc;
            c2 = splitChild.left; c3 = splitChild.right;
        }

        TwoThreeNode<E> left = new TwoThreeNode<>();
        left.leaf = false;
        left.key1 = k0;
        left.lc = c0;
        left.rc = c1;
        left.mc = null;
        left.key2 = null;
        if (left.lc != null) left.leaf = false;

        TwoThreeNode<E> right = new TwoThreeNode<>();
        right.leaf = false;
        right.key1 = k2;
        right.lc = c2;
        right.rc = c3;
        right.mc = null;
        right.key2 = null;
        if (right.lc != null) right.leaf = false;


        return new Split<>(k1, right, left);
    }



    private Split<E> insertIntoLeaf(TwoThreeNode<E> node, E key){
        if (node.key2 == null) {
            // absorb into 2-node leaf → become 3-node leaf with sorted keys
            if (less(key, node.key1)) {
                node.key2 = node.key1;
                node.key1 = key;
            } else {
                node.key2 = key;
            }
            return null;
        } else {
            /**
             3 node leaf --> split
             Compute the sorted order of the three values: a ≤ b ≤ c (using lte = “less than or equal”).

             @param Case1: key ≤ key1 → (a=key, b=key1, c=key2)

             @param Case2: key1 < key ≤ key2 → (a=key1, b=key, c=key2)

             @param Cas3: key > key2 → (a=key1, b=key2, c=key)
             */

            E a, b, c;
            if (less(key, node.key1)) {           // key <= key1
                a = key;         b = node.key1;   c = node.key2;
            } else if (lessOrEqaul(key, node.key2)) { // key1 < key <= key2
                a = node.key1;   b = key;         c = node.key2;
            } else {                                // key > key2
                a = node.key1;   b = node.key2;   c = key;
            }
            TwoThreeNode<E> left  = new TwoThreeNode<>();
            TwoThreeNode<E> right = new TwoThreeNode<>();
            left.leaf = right.leaf = true;
            left.key1 = a;        left.key2 = null;
            right.key1 = c;       right.key2 = null;
            // Clear current node’s keys not necessary since parent will replace pointers
            return new Split<>(b, left, right);
        }
    }



    private boolean equal(E a, E b){return a!= null & b!= null & a.compareTo(b)==0;}
    private boolean lessOrEqaul(E a, E b){return a.compareTo(b)<=0;}
    private boolean less(E a, E b){return a.compareTo(b)<0;}




    private static final class Split<T>{
        private final T middle;
        private final TwoThreeNode<T> left, right;
        public Split(T middle, TwoThreeNode<T> left, TwoThreeNode<T> right){
            this.middle = middle;
            this.left = left;
            this.right = right;
        }
    }

}
