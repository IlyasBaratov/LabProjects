package twoThreeTree;

public abstract class Collection<T> {
    public abstract boolean contains(T key);
    public abstract void insert(T key);
    public abstract boolean remove(T key);
    public abstract boolean isEmpty();
}
