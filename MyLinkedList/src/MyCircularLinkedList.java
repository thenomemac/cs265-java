/**
 * Created by thenome on 5/10/16.
 */

public class MyCircularLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;

    /** default constructor */
    public MyCircularLinkedList () {
    }

    /** constructor from an array of objects */
    public MyCircularLinkedList (E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]); // Warning: don’t use super(objects)!
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /** Return the element from this list at the specified index */
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.element;
        }
    }

    /** get first element */
    public E getFirst() {
        return get(0);
    }

    /** get last element */
    public E getLast() {
        return get(size - 1);
    }

    /** Return the index of the first matching element in this list.  Return -1 if no match. */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e))
                return i;
        }
        return -1;
    }

    /** Return the index of the last matching element in this list. Return -1 if no match. */
    public int lastIndexOf(E e){
        for (int i = size; i < 0; i--){
            if (get(i).equals(e))
                return i;
        }
        return -1;
    }

    /** Replace the element at the specified position in this list
     *  with the specified element and returns element being replaced. */
    public E set(int index, E e) {
        if (index < 0 || index >= size) return null;
        else {
            E oldValue = get(index);
            add(index, e);
            remove(index + 1);
            return oldValue;
        }
    }

    /** Return true if this list contains the element */
    public boolean contains(E e){
        if (indexOf(e) != -1)
            return true;
        else
            return false;
    }

    /** Adds the object to the head of the list */
    public void addFirst(E o) {
        Node<E> newNode = new Node<E>(o);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null) // only when adding the first element do we need to set the tail
            tail = head;
        // for circular list add pointer to head from tail
        tail.next = head;
    }

    /** Adds the object to the tail of the list */
    public void addLast(E o) {
        if (tail == null) {
            head = tail = new Node<E>(o);
        }
        else {
            tail.next = new Node<E>(o);
            tail = tail.next;
        }
        size++;
        // for circular list add pointer to head from tail
        tail.next = head;
    }

    /** Add a new element at index */
    public void add(int index, E obj) {
        if (index == 0) addFirst(obj);
        else if (index >= size) addLast(obj);
        else {

            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;

            Node<E> temp = current.next;
            current.next = new Node<E>(obj);
            (current.next).next = temp;
            size++;

        }
    }

    /** Removes the first object from the list */
    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            //circular list: prevent infinite loop when head.next = head
            if (size == 0) head = null;
            if (head == null) tail = null;
            return temp.element;
        }
    }

    /** Removes the last object from the list */
    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1)
        {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else
        {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++)
                current = current.next;
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            // for circular list tail.next = head
            tail.next = head;
            size--;
            return temp.element;
        }
    }

    /** Removes at index */
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /** Override toString() to return elements in the list */
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(get(i));
            if (i < size - 1) result.append(", ");
        }
        return result.toString() + "]";
    }
}
