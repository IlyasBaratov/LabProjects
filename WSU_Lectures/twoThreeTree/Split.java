package twoThreeTree;

public final class Split<E> {
    final E middle;
    final TwoThreeNode<E> left ,right;

    public Split(E middle, TwoThreeNode<E> left, TwoThreeNode<E> right) {
        this.middle = middle;
        this.left = left;
        this.right = right;
    }
}
