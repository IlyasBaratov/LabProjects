package AVL_Tree;

public class Main {
    public static void main(String[] args) {
        AVLTee <Integer> avlTee = new AVLTee<>();
        Integer[] numbers = {30, 20, 40, 10, 25, 35, 50, 5, 15, 27};
        for (Integer num : numbers){
            avlTee.insert(num);
        }

        System.out.println("In-Order traversal after inserting");
        avlTee.printOrder();
        System.out.println("\n\n");
        int a = 25;
        System.out.println("removing: "+a);
        avlTee.remove(a);
        System.out.println("traversal after removing "+a);
        avlTee.printOrder();
    }
}
