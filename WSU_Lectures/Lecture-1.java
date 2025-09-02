public class Lecture-1 {
    public static void main(String[] args) {
        String [] array = {"Leia", "Boba", "Darth", "R2D2", "Han", "Luke", "Chewy", "Jabba"};
//        Integer [] array = {1,2,3,4,5,6,7,8};
        TreeSet<String> set = new TreeSet<>();
        for (String n : array){
            set.add(n);
        }
        System.out.print("Preorder: ");
        System.out.println();
        set.PreOrder();
        System.out.println();
        System.out.println("Inorder: ");
        set.InOrder();
        System.out.println();
        System.out.println("Postorder: ");
        set.PostOrder();

    }
}

class TreeSet < T extends Comparable <T> >{
    BinaryNode <T> head;
    public TreeSet(){
        this.head = null;
    }
    public void add (T key){
        BinaryNode <T> current = new BinaryNode<>(key);
        if (head==null){
            head = current;
        }
        else {
            BinaryNode<T> focus = head;
            BinaryNode<T> parent;
            while (true){
                parent = focus;
                if (key.compareTo(focus.key)<0){
                    focus = focus.left;
                    if (focus == null){
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
    public void InOrder(){
        InOrder(head);
    }
    private void InOrder(BinaryNode <T> node){
        if (node != null){
            InOrder(node.left);
            System.out.print(node.key + "  ");
            InOrder(node.right);
        }
    }public void PreOrder(){
        PreOrder(head);
    }
    private void PreOrder (BinaryNode <T> node){
        if (node != null){
            System.out.print(node.key + "  ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    public void PostOrder(){
        PostOrder(head);
    }

    private void PostOrder(BinaryNode <T> node) {
        if (node != null){
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.key+ "  ");
        }
    }

}






class BinaryNode <T> {
    T key;
    BinaryNode left;
    BinaryNode right;
    public BinaryNode (T key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}


