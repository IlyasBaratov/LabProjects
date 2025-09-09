package microAssignmet_1;
/**

 Minimal collection interface for this micro-assignment.

 @param <T> element type
 */
public abstract class Collection<T> {

    /**

    Adds an element to the collection.

    @param item element to add
    */
	public abstract void addElement(T item);
    /**

     @return true if the collection has no elements
     */
	public abstract boolean isEmpty();
    /**

     @return current number of elements
     */
	public abstract int getSize();
}
