package microAssignmet_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**

 Minimal driver for building and exercising the {@link BinarySearchTree}.

 <p>Creates a tree from a sample word array, prints traversals,

 performs a few deletions, and prints results to verify structure.</p>
 */
public class MA1_Main {

    /**

    Program entry point.

    @param args unused
    */
	public static void main(String[] args) {
		
		//Build a temporary tree for demo
		// To Be Implemented
        BinarySearchTree<String> list = new BinarySearchTree<>();

        String [] array = {"Leia", "Boba", "Darth", "R2D2", "Han", "Luke", "Chewy", "Jabba"};

        for (String n : array){
            list.addElement(n);
        }
		
		//root is the root of the tree.
		//let's try traversal now!

		System.out.println("------------");
		System.out.println("Pre-order Travesal");
		 preorder(list._root);
		System.out.println();

        list.removeElement("Boba");
		
		System.out.println("------------");
		System.out.println("Post-order Travesal");
		 postorder(list._root);
		System.out.println();

		System.out.println("------------");
		System.out.println("In-order Travesal");
//		 inorder(list._root);
		System.out.println();
	}
	
	public static void preorder(BinaryNode<String> root)
	{
		if (root == null) return;
		
		System.out.print(root.getValue()+ " ");
		preorder(root.getLeftChild());
		preorder(root.getRightChild());		
	}
	
	public static void postorder(BinaryNode<String> root)
	{
		if (root == null) return;
		
		postorder(root.getLeftChild());
		postorder(root.getRightChild());
		System.out.print(root.getValue()+ " ");
	}
	
	public static void inorder(BinaryNode<String> root)
	{
		if (root == null) return;
		
		inorder(root.getLeftChild());
		System.out.print(root.getValue()+" ");
		inorder(root.getRightChild());
	}
}
