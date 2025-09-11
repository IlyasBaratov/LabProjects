package AVL_Tree;

public class AVLTee<T extends Comparable<T>> {
    Node<T> head;
    public AVLTee(){
        this.head = null;
    }
    public int height(Node <T> node){
        if (node == null){
            return 0;
        }
        else {
            return node.height;
        }
    }

    public void insert(T key){
        head = insert(head, key);
    }
    public void remove(T key){
        head = remove(head, key);
    }

    public int getBalance(Node <T> node){
        if (node == null){
            return 0;
        }
        else {
            return height(node.left) - height(node.right);
        }
    }
    public void updateHeight(Node <T> node){
        node.height = Math.max(height(node.left),height(node.right))+1;
    }
    public Node<T> minNode(Node<T> node){
        Node<T> current = node;
        while (current.getLeft() != null){
            current = current.left;
        }
        return current;
    }

    public Node<T> RightRotate(Node<T> node){
        Node<T> leftNode = node.getLeft();
        Node<T> leftRightNode = leftNode.getRight();

        /*
              Initial structure:
                   node
                    /
                leftNode
                     \
                       leftRightNode
         */

        // Perform Rotation

        leftNode.setRight(node);
        node.setLeft(leftRightNode);

        /*
           After RightRotation:
                leftNode
                      \
                      node
                      /
              leftRightNode
         */

        // Update heights:
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }
    public Node<T> LeftRotate(Node<T> node){
        Node<T> RightNode = node.right;
        Node<T> RightLeftNode = RightNode.left;
        RightNode.setLeft(node);
        node.setRight(RightLeftNode);

        updateHeight(node);
        updateHeight(RightNode);

        return RightNode;

    }

    public Node<T> rebalance(Node<T> node, T key) {
        int height = getBalance(node);
        // RR case
        if (height>1 && key.compareTo(node.left.key)<0){
            return RightRotate(node);
        }
        // LL case
        if (height<-1 && key.compareTo(node.right.key)>0){
            return LeftRotate(node);
        }
        //RL case
        if (height<-1 && key.compareTo(node.right.key)<0){
            node.setRight(RightRotate(node.getRight()));
            return LeftRotate(node);
        }
        // LR case
        if (height>1 && key.compareTo(node.getLeft().getKey())>0){
            node.setLeft(LeftRotate(node.getLeft()));
            return RightRotate(node);
        }

        return node;
    }

    private Node<T> insert (Node<T> node, T key){
        if (node == null){
            return new Node<T>(key);
        }
        if (key.compareTo(node.key)<0){
            node.left = insert(node.left, key);
        }
        else if (key.compareTo(node.key)>0) {
            node.right = insert(node.right, key);
        }
        else {
            return node;
        }
        updateHeight(node);
        return rebalance(node, key);
    }
    private Node<T> remove (Node<T> node, T key){
        if (node == null) return null;
        if (key.compareTo(node.key)<0){
            node.left = remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        }
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            }
            else {
                // two children case
                Node<T> succ = minNode(node.right);
                node.key = succ.key;
                node.right = remove(node.right, succ.key);
            }
        }
        if (node == null) return null;
        updateHeight(node);
        return rebalance(node, key);
    }
    public void inOrder(Node<T> node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.key+" ");
            inOrder(node.right);
        }
    }
    public void printOrder(){
        inOrder(head);
        System.out.println();
    }
}

















