package AVL_Tree;

public class Node <T> {
    T key;
    int height;
    Node <T> left;
    Node <T> right;
    public Node(T key){
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
    public boolean isLeaf(){
        return left == null & right == null;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
