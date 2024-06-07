public class Binary_practice {
    public static void main(String[] args) {
//        Integer [] array = {17,41,29,6,9,81,40};
        String [] array = {"Leia", "Boba", "Darth", "R2D2", "Han", "Luke", "Chewy", "Jabba"};
        Tree_set<String> set = new Tree_set<>();
//        for (int n : array){
//            set.add(n);
//        }
        for (String n: array){
            set.add(n);
        }
        System.out.print("Preorder: ");
        System.out.println();
        set.preOrder();
        System.out.println();
        System.out.println("Inorder: ");
        set.inOrder();
        System.out.println();
        System.out.println("Postorder: ");
        set.postOrder();
    }
}

class Tree_set <T extends Comparable <T>> {
    Binary_node <T> head;
    public Tree_set(){
        this.head = null;
    }

    public void add(T key){
        Binary_node <T> current = new Binary_node<>(key);
        if (head == null){
            head = current;
        }
        else {
            Binary_node <T> focus = head;
            Binary_node<T> parent;
            while (true){
                parent = focus;
                if (key.compareTo(focus.key)<0){
                    focus = focus.left;
                    if (focus == null ){
                        parent.left = current;
                        return;
                    }
                }
                else {
                    focus = focus.right;
                    if (focus == null){
                        parent.right = current;
                        return;
                    }
                }
            }

        }
    }

    public void remove(T key){

    }
    public void inOrder(){
        inOrder(head);
    }
    private void inOrder(Binary_node<T> node){
        if (node!=null){
            inOrder(node.left);
            System.out.print(node.key+"  ");
            inOrder(node.right);
        }
    }
    public void preOrder(){
        preOrder(head);
    }
    private void preOrder(Binary_node<T> node){
        if (node != null){
            System.out.print(node.key+"  ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public void postOrder(){
        postOrder(head);
    }
    private void postOrder(Binary_node <T> node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key+ "  ");
        }
    }

}
class Binary_node <T> {
    T key;
    Binary_node left;
    Binary_node right;

    public Binary_node(T key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
