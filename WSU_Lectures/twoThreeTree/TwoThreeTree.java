package twoThreeTree;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TwoThreeTree <T extends Comparable<T>> extends Collection<T> {
    TwoThreeNode<T> root;




    @Override
    public boolean contains(T key) {
        return containsHelp(key);
    }

    @Override
    public void insert(T key) {
        Objects.requireNonNull(key, "key");

        if (root == null){
            root = new TwoThreeNode<>(key, true);
            return;
        }
        if (contains(key)) return;
        Split<T> res = insertRecursive(root, key);
        if (res != null){
            TwoThreeNode<T> newRoot = new TwoThreeNode<>();
            newRoot.leaf = false;
            newRoot.setKey1(res.middle);
            newRoot.setLeftChild(res.left);
            newRoot.setRightChild(res.right);
            root = newRoot;
        }

    }

    @Override
    public boolean remove(T key) {

        Objects.requireNonNull(key, "key");
        if (!contains(key)) return false;
        List<T> all = inOrder();
        root = null;
        for (T n : all){
            if (!eqaul(n, key)) insert(n);
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
    public List<T> inOrder(){
        List<T> res = new ArrayList<>();
        inOrderHelp(root, res);
        return res;
    }


    private void inOrderHelp(TwoThreeNode node, List<T> out){

        if (node == null) return;
        if (node.leaf){
            if (node.getKey1() != null) out.add((T) node.getKey1());
            if (node.getKey2() != null) out.add((T) node.getKey2());
            return;
        }
        if (node.getKey2() == null){
            inOrderHelp(node.getLeftChild(), out);
            out.add((T) node.getKey1());
            inOrderHelp(node.getRightChild(), out);
        }
        else {
            inOrderHelp(node.getLeftChild(), out);
            out.add((T) node.getKey1());
            inOrderHelp(node.getMiddleChild(), out);
            out.add((T) node.getKey2());
            inOrderHelp(node.getRightChild(), out);
        }

    }


    private boolean containsHelp(T key){
        Objects.requireNonNull(key,"key");
        TwoThreeNode<T> current = root;
        while (current!= null){
            if (eqaul(key, current.getKey1())) return true;
            if (current.getKey2() != null & eqaul(key, current.getKey2())) return true;
            if (lessThan(key, current.getKey1())){
                current = current.getLeftChild();
            }
            else if (current.getKey2() == null || lessThan(key, current.getKey2())) {
                current = (current.getKey2() ==null) ? current.getRightChild() : current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
        }
        return false;
    }


    /*
    Goal: Insert key into the subtree rooted at x.

    Returns: Either null (no split bubbled up), or a Split<E> object containing:

        middle: the promoted key,

        left/right: the two nodes that resulted from splitting the child.
     */
    private Split<T> insertRecursive(TwoThreeNode<T> node, T key){
        if (node.leaf){
            insertIntoLeaf(node, key);
        }
        int childIndex=0;
        TwoThreeNode<T> child;
        if (lessThan(key, node.getKey1())){
            childIndex = 0;
            child = node.getLeftChild();
        } else if (node.getKey2() == null || lessThan(key, node.getKey2())) {
            childIndex = (node.getKey2() == null) ? 1 : 1;
            child = (node.getKey2() == null) ? node.getRightChild() : node.getLeftChild();
        }
        else {
            childIndex = (node.getKey2() == null) ? 1 : 2;
            child = node.getRightChild();
        }
        Split<T> split = insertRecursive(child, key);
        if (split == null) return null;

        if (node.getKey2() == null){
            if (childIndex == 0){
                node.setKey2(node.getKey1());
                node.setKey1(split.middle);

                node.setMiddleChild(node.getRightChild());
                node.setLeftChild(split.left);
                node.setRightChild(split.right);
            }
            else {
                return splitParent3Node(node, split, childIndex);
            }
        }
        return null;
    }

    private Split<T> splitParent3Node(TwoThreeNode<T> node, Split<T> splitChild, int childIndex){

        T key1 = node.getKey1();
        T key2 = node.getKey2();

        T K0, K1, K2;

        TwoThreeNode<T> C0, C1, C2, C3;
        if (childIndex == 0){
            K0 = splitChild.middle; K1 = key1; K2 = key2;
            C0 = splitChild.left;
            C1 = splitChild.right;
            C2 = node.getMiddleChild();
            C3 = node.getRightChild();
        }
        else if (childIndex == 1) {
            K0 = key1;K1 = splitChild.middle; K2 = key2;
            C0 = node.getLeftChild();
            C1 = splitChild.left;
            C2 = splitChild.right;
            C3 = node.getRightChild();
        }
        else {
            K0 = key1; K1 = key2; K2 = splitChild.middle;
            C0 = node.getLeftChild();
            C1 = node.getMiddleChild();
            C2 = splitChild.left;
            C3 = splitChild.right;
        }

        TwoThreeNode<T> left = new TwoThreeNode<>();
        left.leaf = false;
        left.setKey1(K0);
        left.setLeftChild(C0);
        left.setRightChild(C1);
        left.setMiddleChild(null);
        left.setKey2(null);

        if (left.getLeftChild() != null) left.leaf = false;

        TwoThreeNode<T> right = new TwoThreeNode<>();
        right.leaf = false;
        right.setKey1(K2);
        right.setLeftChild(C2);
        right.setRightChild(C3);
        right.setMiddleChild(null);
        right.setKey2(null);
        if (right.getLeftChild() != null) right.leaf = false;

        return new Split<>(K1, left, right);

    }


    public Split<T> insertIntoLeaf(TwoThreeNode<T> node, T key ){
        if (node.getKey2() == null){
            if (lessThan(key, node.getKey1())){
                node.setKey2(node.getKey1());
                node.setKey1(key);
            }
            else {
                node.setKey2(key);
            }
            return null;
        }
        else {
            /*
            3 node leaf --> split
            Compute the sorted order of the three values: a ≤ b ≤ c (using lte = “less than or equal”).

            Case 1: key ≤ key1 → (a=key, b=key1, c=key2)

            Case 2: key1 < key ≤ key2 → (a=key1, b=key, c=key2)

            Case 3: key > key2 → (a=key1, b=key2, c=key) */


            T a, b, c;
            if (lessThanEqual(key, node.getKey1())){
                a = key; b = node.getKey1(); c = node.getKey2();
            }
            if (lessThanEqual(key, node.getKey2())){
                a = node.getKey1(); b = key; c = node.getKey2();
            }
            else {
                a = node.getKey1(); b = node.getKey2(); c = key;
            }
            TwoThreeNode<T> left = new TwoThreeNode<>();
            left.leaf = true;
            left.setKey1(a);

            TwoThreeNode<T> right = new TwoThreeNode<>();
            right.leaf = true;
            right.setKey1(c);

            return new Split<T>(b, left, right);

        }
    }




    // Utilities
    private boolean lessThan(T a, T b){
        return a.compareTo(b)<0;
    }
    private boolean lessThanEqual(T a, T b){
        return a.compareTo(b)<=0;
    }
    private boolean eqaul(T a, T b){
        return a!= null & b!= null & a.compareTo(b)==0;
    }
}
