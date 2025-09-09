//Node in a Binary Tree
package microAssignmet_1;
public class BinaryNode<T> {

/**

 A single node in a binary search tree storing a value and links to left/right children.

 @param <T> the element type, which must be comparable for BST ordering
 **/

	//underlying value in the node
	private T _value;
	
	//a *pointer* to the left child 
	//In Java, just the left child

    /** Left child reference (may be null). */
	BinaryNode<T> _left_child;
	
	//right
    /** Right child reference (may be null). */
	BinaryNode<T> _right_child;
	
	public BinaryNode()
	{
		_left_child = null;
		_right_child = null;
	}

    /**

     Creates a node with the given value and null children.

     @param value the value to store
     */
	public BinaryNode(T value)
	{
		_value = value;
	}
	
	public BinaryNode(BinaryNode<T> left, BinaryNode<T> right)
	{
		_left_child = left;
		_right_child = right;
	}

    /**

     @return true if both children are null
     */
	public boolean isLeaf()
	{
		return _left_child == null && _right_child == null;
	}

    /**

     @return the left child, or null if none
     */
	public BinaryNode<T> getLeftChild()
	{
		return _left_child;
	}

    /**

     Sets the left child reference.

     @param left child the new left child (may be null)
     **/
	public void setLeftChild(BinaryNode<T> left)
	{
		_left_child = left;
	}

    /**

     @return the right child, or null if none
     */
	public BinaryNode<T> getRightChild()
	{
		return _right_child;
	}

    /**

     Sets the right child reference.

     @param right child the new right child (may be null)
     */
	public void setRightChild(BinaryNode<T> right)
	{
		_right_child = right;
	}

	/**

            @return the stored value
     */
	public T getValue()
	{
		return _value;
	}

    /**

      @param value sets the value
     */
	public void setValue(T value)
	{
		_value = value;
	}
}
