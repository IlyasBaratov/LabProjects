package twoThreeTree;

public class TwoThreeNode<T> {
    private T key1, key2;
    private TwoThreeNode<T> leftChild,rightChild, middleChild;
    public boolean leaf;
    public TwoThreeNode(){
        this.leaf = true;
    }
    public TwoThreeNode(T key1){
        this.key1 = key1;
        this.leaf = true;
        leftChild = middleChild = rightChild = null;
    }
    public TwoThreeNode(T key1, boolean leaf){
        this.key1 = key1;
        this.leaf = leaf;
    }

    public T getKey1() {
        return key1;
    }

    public void setKey1(T key1) {
        this.key1 = key1;
    }

    public T getKey2() {
        return key2;
    }

    public void setKey2(T key2) {
        this.key2 = key2;
    }

    public TwoThreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TwoThreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TwoThreeNode<T> getMiddleChild() {
        return middleChild;
    }

    public void setMiddleChild(TwoThreeNode<T> middleChild) {
        this.middleChild = middleChild;
    }

    public TwoThreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TwoThreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
