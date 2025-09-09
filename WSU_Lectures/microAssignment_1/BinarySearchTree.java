
/**

 A binary search tree with insertion and deletion of comparable elements.

 <p>

 Deletion with two children alternates between using the in-order predecessor

 (max of left subtree) and the in-order successor (min of right subtree).

 @param <T> element type (must be comparable for BST ordering)
 */

package microAssignmet_1;

public class BinarySearchTree<T extends Comparable<T>> extends Collection<T> {
	
	//keeps track of the remove direction (left or right)
	private int _remove_counter = 0;
	
	//keeps track of BST size
	private int _size_counter = 0;
	
	protected BinaryNode<T> _root = null;
	
	//removes the largest element from the SUBTREE starting at root

    /**

     Removes the largest node from this subtree and returns the updated subtree root.

     @param root subtree root (may be null)

     @return new root after removal (may be null)
     */
	protected BinaryNode<T> removeLargest(BinaryNode<T> root)
	{
		//NULL tree/empty tree
		if (root == null) return null;
		
		//BASE CASE: root is the largest
		if (root.getRightChild() == null)
		{
			return root.getLeftChild();
		}		
		
		//Recursive 		
		BinaryNode<T> new_right = removeLargest(root.getRightChild());
		
		//reconfigure our right pointer to the returned value
		root.setRightChild(new_right);				
		
		return root;
	}
	
	//removes the smallest element
    /**

     Removes the smallest node from this subtree and returns the updated subtree root.

     @param root subtree root (may be null)

     @return new root after removal (may be null)
     */
	protected BinaryNode<T> removeSmallest(BinaryNode<T> root)
	{
		//NULL tree/empty tree
		if (root == null) return null;
		
		//without recursion
		BinaryNode<T> pre = null;
		
		//root is the smallest value
		while (root.getLeftChild() != null)
		{
			pre = root;
			root = root.getLeftChild();
		}
		
		//check if pre is null
		if(pre != null)
			pre.setLeftChild(root.getRightChild());
		
		return pre;
	}


    /**

     @param root subtree root

     @return the node with the largest key in this subtree, or null if subtree empty
     */
	protected BinaryNode<T> findLargest(BinaryNode<T> root)
	{
		while(root != null && root.getRightChild() != null)
			root = root.getRightChild();
		return root;
	}

    /**

     @param root subtree root

     @return the node with the smallest key in this subtree, or null if subtree empty
     */
	protected BinaryNode<T> findSmallest(BinaryNode<T> root)
	{
		while(root != null && root.getLeftChild() != null)
			root = root.getLeftChild();
		return root;
	}

    /**

     Internal recursive insertion.

     @param root subtree root (may be null)

     @param item element to insert

     @return the (possibly new) root of this subtree
     */
	protected BinaryNode<T> addElementHelper(BinaryNode<T> root, T item) {

		// To Be Implemented
		
		//check for null first

        BinaryNode <T> current = new BinaryNode<>(item);

		//if root is null, create new node return pointer to that node
        //you can choose whether to use recursion or not
        //to compare, use this method of the item: item.compareTo(/*arguments to compare to*/)
        if (root == null){
            root = current;
        }
		//if not null, compare value, add to correct place
        else {
            BinaryNode<T> focus = root;
            BinaryNode<T> parent;
            while (true){
                parent = focus;
                if (item.compareTo(focus.getValue())<0){
                    focus = focus._left_child;
                    if (focus == null){
                        parent._left_child = current;
                        break;
                    }
                }
                else {
                    focus = focus._right_child;
                    if (focus == null){
                        parent._right_child = current;
                        break;
                    }
                }
            }
        }

				
		//always return root because we don't know where the recursion ends
		return root;
	}

    /**

     Internal recursive removal.

     <ul>
     <li>0 or 1 child: splice the node out.</li>
     <li>2 children: copy predecessor/successor
     and remove that node from the corresponding subtree.</li>

     </ul>

     @param root subtree root (may be null)

     @param item element to remove

     @return the (possibly new) root of this subtree
     */
	protected BinaryNode<T> removeElementHelper(BinaryNode<T> root, T item)
	{
		//check for null
		//if root is null, return it.
		// To Be Implemented
        if (root == null){
            return null;
        }
		
		//three possibilities:
		//we found the item (root value == item)
		//item is less than root (item < root)
		//item is greater than root (item > root)

		if (item.compareTo(root.getValue()) == 0) {

            if (root.getLeftChild() == null){
                return root.getRightChild();
            }
            if (root.getRightChild() == null){
                return root.getLeftChild();
            }

			//increment removal counter
			_remove_counter++;
			
			//we found the item
			//do we remove from the left or right?
			if (_remove_counter % 2 == 0) {
				//let's assume we are removing from the left when it's an even number
				// To Be Implemented
                BinaryNode<T> focus = findLargest(root.getLeftChild());
                root.setValue(focus.getValue());
                root.setLeftChild(removeLargest(root.getLeftChild()));


			}
			else {

				//remove from the right subtree when it's an odd number
				// To Be Implemented
                BinaryNode<T>focus = findSmallest(root.getRightChild());
                root.setValue(focus.getValue());
                root.setRightChild(removeSmallest(root.getRightChild()));
			}
		}
		else if (item.compareTo(root.getValue()) < 0) {
			//item is less than root
			//go on finding it in the left subtree
			BinaryNode<T> result = removeElementHelper( root.getLeftChild(), item);
			
			//the recursive call *might* have altered our
			//left child's structure. Inform root of this change
			root.setLeftChild(result);
		}
		else {
			//item is greater than root
			//finding it in the right subtree
			BinaryNode<T> result = removeElementHelper(root.getRightChild(), item);
			root.setRightChild(result);
		}
		
		return root;
	}

    /**

     Inserts {@code item} into the BST (duplicates ignored or placed consistently).

     @param item element to insert
     */
	@Override
	public void addElement(T item) {		
		_root = addElementHelper(_root, item);
		_size_counter++;
	}

    /**

     Removes one occurrence of {@code item} from the BST if present.

     Size is decremented only when a node is actually removed.

     @param item element to remove
     */
	public void removeElement(T item) {
		_root = removeElementHelper(_root, item);
		_size_counter--;
	}

    /** @return true if the tree contains no nodes. */
	@Override
	public boolean isEmpty() {		
		return _root == null;
	}

    /** @return current number of nodes in the tree. */
	@Override
	public int getSize() {		
		return _size_counter;
	}

}
