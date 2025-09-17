package microAssignment_2;


/**
 * A generic AVL self-balancing binary search tree.
 * <p>
 * This tree keeps itself balanced via single and double rotations after inserts
 * and removals. We use the height convention:
 * <ul>
 *   <li>{@code null} child has height -1</li>
 *   <li>a leaf node has height 0</li>
 * </ul>
 * Heights are recomputed and balance is restored on the way back up the
 * recursion using {@link #setHeight(AvlNode)} and {@link #balance(AvlNode)}.
 *
 * @param <T> element type; must be {@link Comparable}
 */

public class AvlTree<T extends Comparable<T>> extends Collection<T>
{
	//keeps track of the remove direction (left or right)
	private int _remove_counter = 0;
	
	//keeps track of BST size
	private int _size_counter = 0;
	
	protected AvlNode<T> _root = null;
	
	//removes the largest element from the subtree starting at root

    /**
     * Removes the largest element from the subtree rooted at {@code root}.
     *
     * @param root subtree root
     * @return the new subtree root after removal
     */
	protected AvlNode<T> removeLargest(AvlNode<T> root)
	{
		if (root == null)
			return root;
		
		//BASE CASE: root is largest (has no right node)
		if (root.getRightChild() == null)
		{
			AvlNode<T> left = root.getLeftChild();
			//return left node to parent
			return left;
		}
		else
		{
			//RECURSIVE CASE:
			AvlNode<T> new_right = removeLargest(root.getRightChild());
			root.setRightChild(new_right);
			return root;
		}
	}

    /**
     * Removes the smallest element from the subtree rooted at {@code root}.
     *
     * @param root subtree root
     * @return the new subtree root after removal
     */
	protected AvlNode<T> removeSmallest(AvlNode<T> root)
	{
		if (root == null)
			return root;
		
		//BASE CASE: root is smallest (has no left node)
		if (root.getLeftChild() == null)
		{
			AvlNode<T> right = root.getRightChild();
			//return right node to parent
			return right;
		}
		else
		{
			//RECURSIVE CASE:
			AvlNode<T> new_left = removeSmallest(root.getLeftChild());
			root.setLeftChild(new_left);
			return root;
		}
	}

    /**
     * Restores AVL balance at {@code root} by applying the appropriate rotation(s).
     * Uses the tree-wide {@link #getBalance(AvlNode)}
     * @param root subtree root to (re)balance
     * @return new subtree root after rebalancing (may be different from input)
     */
	protected AvlNode<T> balance(AvlNode<T> root)
	{
		//MA2 TODO: check for null roots first
        if (root == null){
            return null;
        }
        int height = getBalance(root);
        // Left heavy
        if (height>1){
            if (getBalance(root.getLeftChild())<0){
                root.setLeftChild(rotateLeft(root.getLeftChild()));
            }
            root = rotateRight(root);
        }
        // Right heavy
        if (height<-1){
            if (getBalance(root.getRightChild())>0){
                root.setRightChild((rotateRight(root.getRightChild())));
            }
            root = rotateLeft(root);
        }


		return root;
	}

    /**
     * Performs a left rotation around {@code root}.
     *
     * @param root subtree root to rotate
     * @return the new subtree root after rotation
     */
	protected AvlNode<T> rotateLeft(AvlNode<T> root)
	{
		//MA2 TODO: check for null roots first
        if (root == null){
            return null;
        }
        AvlNode<T> RightNode = root.getRightChild();
        if (RightNode == null) return root;

        AvlNode<T> RightLeftNode = RightNode.getLeftChild();

        RightNode.setLeftChild(root);
        root.setRightChild(RightLeftNode);
		
		//new root comes from right side
		AvlNode<T> new_root = root.getRightChild();
		
		//MA2 TODO: rotate left and return "new_root"
        setHeight(root);
//		return setHeight(new_root);
        setHeight(RightNode);
        return RightNode;
	}

    /**
     * Performs a right rotation around {@code root}.
     *
     * @param root subtree root to rotate
     * @return the new subtree root after rotation
     */
	protected AvlNode<T> rotateRight(AvlNode<T> root)
	{
		//MA2 TODO: check for null roots
        if (root == null) return null;


        AvlNode<T> leftNode = root.getLeftChild();
        if (leftNode == null) return root;

        AvlNode<T> leftRightNode = leftNode.getRightChild();

        leftNode.setRightChild(root);
        root.setLeftChild(leftRightNode);
		
		//new root comes from left side
		AvlNode<T> new_root = root.getLeftChild();
		
		//MA2 TODO: rotate right and return "new_root"
        setHeight(root);
//		return setHeight(new_root);
        setHeight(leftNode);
        return leftNode;
	}

    /**
     * Recomputes {@code root}'s height from its children (null = -1) and, if the
     * balance factor is outside [-1, 1], rebalances the node.
     *
     * @param root node to recompute
     * @return the (possibly new) subtree root after rebalancing
     */
	protected AvlNode<T> setHeight(AvlNode<T> root)
	{
		//check for null roots
		if (root == null)
			return root;
		
		AvlNode<T> left = root.getLeftChild();
		AvlNode<T> right = root.getRightChild();
		
		//start at 1 because we assume null trees have height of -1
		int height = 1;
		
		//add in larger of left or right heights
		int left_height = (left == null) ? -1 : left.getHeight();
		int right_height = (right == null) ? -1 : right.getHeight();
		
		height += (left_height < right_height) ? right_height: left_height;
		
		//reassign new height to root
		root.setHeight(height);
		
		//check to see if balance factor is out of balance
		int balance_factor = root.getBalanceFactor();
		if (balance_factor < -1 || balance_factor > 1)
		{
			return balance(root);
		}
		return root;
	}

    /**
     * Recursive insert helper. Inserts {@code item} into the subtree and returns
     * the new subtree root after rebalancing.
     *
     * @param root subtree root
     * @param item value to insert
     * @return new subtree root after insertion
     */
	protected AvlNode<T> addElementHelper(AvlNode<T> root, T item)
	{
		//BASE CASE: create new node
		if (root == null)
		{
			root = new AvlNode<T>();
			root.setValue(item);
			return root;
		}
		
		//else, use the same helper as in BST
		//RECURSIVE CASE: figure out which child to call
		//is "item" larger than us?
		if (item.compareTo(root.getValue()) > 0){
			AvlNode<T> right_child = root.getRightChild();
			AvlNode<T> result = addElementHelper(right_child, item);
			root.setRightChild(result);
		}
		else if (item.compareTo(root.getValue()) < 0)
		{
			//same as above, except switching from right to left
			AvlNode<T> left_child = root.getLeftChild();
			AvlNode<T> result = addElementHelper(left_child, item);
			root.setLeftChild(result);
		}
		else
		{
			//duplicates, do nothing
			return root;
		}
		
		//For BST, this process would end
		//return root;
		
		//For AVL though, we need to return a balanced node
		return setHeight(root);
	}


    /**
     * Recursive remove helper. Removes {@code item} from the subtree and returns
     * the new subtree root after rebalancing.
     *
     * @param root subtree root
     * @param item value to remove
     * @return new subtree root after removal
     */
	protected AvlNode<T> removeElementHelper(AvlNode<T> root, T item)
	{
		//use the same helper as in BST
		//null check
		if (root == null)
			return null;
		
		//three possibilities:
		// we found the item (root value == item)
		// item is less than root (item < root)
		// item is greater than root (item > root)
		if (item.equals(root.getValue()))
		{
			//increment removal counter
			_remove_counter++;
			
			//we found the item
			//do we remove from the left or right?
			if (_remove_counter % 2 == 0)
			{
				//check to see if left is not null
				if (root.getLeftChild() != null)
				{
					//left subtree remove
					//we need the largest from the left side
					AvlNode<T> largest = findLargest(root.getLeftChild());
					
					//take the largest's value, put inside root
					root.setValue(largest.getValue());
					
					//having gotten the value, we can now remove the node from the tree
					AvlNode<T> result = removeLargest(root.getLeftChild());
					root.setLeftChild(result);
					return setHeight(root);
				}
				else
				{
					//else, delete the current root, return the result
					return setHeight(removeSmallest(root));
				}
			}
			else
			{
				//right subtree remove
				if (root.getRightChild() != null)
				{
					AvlNode<T> smallest = findSmallest(root.getRightChild());
					
					root.setValue(smallest.getValue());
					
					AvlNode<T> result = removeSmallest(root.getRightChild());
					root.setRightChild(result);
					return setHeight(root);
				}
				else
				{
					return setHeight(removeLargest(root));
				}
			}				
		}
		else if (item.compareTo(root.getValue()) < 0)
		{
			//item is less than root
			AvlNode<T> result = removeElementHelper(
					root.getLeftChild(), //send along our left child
					item				 //and the same item
					);
			root.setLeftChild(result);
		}
		else
		{
			//item is greater than root
			AvlNode<T> result = removeElementHelper(
					root.getRightChild(),
					item
					);
			root.setRightChild(result);
		}
		
		//similar to addElementHelper, need to balance the root		
		return setHeight(root);
	}


    /**
     * Finds the largest node (rightmost) in the subtree.
     *
     * @param root subtree root
     * @return the largest node or {@code null} if subtree is empty
     */
	protected AvlNode<T> findLargest(AvlNode<T> root)
	{
		while(root != null && root.getRightChild() != null)
			root = root.getRightChild();
		return root;
	}


    /**
     * Finds the smallest node (leftmost) in the subtree.
     *
     * @param root subtree root
     * @return the smallest node or {@code null} if subtree is empty
     */
	protected AvlNode<T> findSmallest(AvlNode<T> root)
	{
		while(root != null && root.getLeftChild() != null)
			root = root.getLeftChild();
		return root;
	}
	
	//provide traverse method for the AVL tree
	public void traverse(AvlTreeTraversal<T> traversal)
	{
		traversal.traverse(_root);
	}

	@Override
	public void addElement(T item) {
		_root = addElementHelper(_root, item);
		_size_counter++;
	}

	@Override	
	public void removeElement(T item) {
		_root = removeElementHelper(_root, item);
		_size_counter--;
	}

	@Override
	public boolean isEmpty() {
		return _root == null;
	}

	@Override
	public int getSize() {
		return _size_counter;
	}

    protected int getBalance(AvlNode<T> node) {
        if (node == null) return 0;
        AvlNode<T> l = node.getLeftChild();
        AvlNode<T> r = node.getRightChild();
        int lh = (l == null) ? -1 : l.getHeight();
        int rh = (r == null) ? -1 : r.getHeight();
        return lh - rh;
    }
}
