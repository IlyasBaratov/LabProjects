public class BinaryTree {
    public binaryNode root;
    public void addNode(int key, String name){
        binaryNode newNode = new binaryNode(key,name);
        if (root == null){
            root = newNode;
        }
        else {
            binaryNode focusNode = root;
            binaryNode parent;
            while (true){
                parent = focusNode;
                if (key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    if (focusNode == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                if (key > focusNode.key){
                    focusNode = focusNode.rightChild;
                    if (focusNode == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    public void inOrderTreaverseTree(binaryNode focusNode){
        if (focusNode!= null){
            inOrderTreaverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTreaverseTree(focusNode.rightChild);
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50,"50");
        tree.addNode(60,"60");
        tree.addNode(43,"43");
        tree.addNode(52,"52");
        tree.addNode(71,"71");
        tree.addNode(12,"12");
        tree.addNode(90,"90");
        tree.addNode(78,"78");
        tree.addNode(34,"34");
        tree.inOrderTreaverseTree(tree.root);

    }
}
class binaryNode {
    int key;
    String name;
    binaryNode leftChild;
    binaryNode rightChild;
    binaryNode(int key, String name){
        this.key = key;
        this.name = name;
    }
    public String toString(){
        return name+" has a key "+ key;
    }
}
