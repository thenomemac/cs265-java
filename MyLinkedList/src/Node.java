/**
 * Created by thenome on 5/10/16.
 */
public class Node<E> {
    // doesn't matter if = null is used or not will test == null either way
    public E element = null; // default is null with or without explicit assignment
    public Node<E> next = null; // default is null with or without explicit assignment
    public Node<E> previous = null; // used only in doubly/circular linked list design

    /** default constructor */
    public Node() {
    }

    /** type protected constructor */
    public Node(E o) {
        element = o;
    }
}
