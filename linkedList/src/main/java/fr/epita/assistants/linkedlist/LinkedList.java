package fr.epita.assistants.linkedlist;

public class LinkedList<T extends Comparable> {

    public class elt {
        T data;
        elt next = null;

        public elt(T data) {
            this.data = data;
        }
    }
    public int size;
    public elt start;

    /**
     * Initializes the list
     **/
    public LinkedList() {
        start = null;
        size = 0;
    }

    /**
     * Inserts the specified element into the list.
     * The elements must be sorted in ascending order.
     * null elements should be at the end of the list.
     *
     * @param e Element to be inserted
     **/
    public void insert(T e) {
        elt new_elt = new elt(e);
        if (start == null)
            start = new_elt;
        else {
            elt tmp = start;
            elt previous = null;
            if (start.data.compareTo(e) >= 0)
                start = new_elt;

            while (tmp != null && tmp.data.compareTo(e) < 0) {
                previous = tmp;
                tmp = tmp.next;
            }
            new_elt.next = tmp;
            if (previous != null)
                previous.next = new_elt;
        }
        this.size++;
    }

    /**
     * Returns the n-th element in the list.
     *
     * @param i Index
     * @return The element at the given index
     * @throws IndexOutOfBoundsException if there is no element at this
     *                                   index.
     **/
    public T get(int i) {
        int acc = 0;
        elt tmp = start;
        while (acc < i && tmp != null) {
            tmp = tmp.next;
            acc++;
        }
        if (tmp == null)
            throw new IndexOutOfBoundsException("No element at this index");

        return tmp.data;

}
    /**
     * Removes the first occurrence of the specified element in the list.
     *
     * @param e Element to remove
     * @return returns the element that has been removed or null
     **/
    public T remove(T e) {
        if (e == null)
            return null;
        elt tmp = start;
        elt previous = null;
        while (tmp != null && tmp.data.compareTo(e) != 0)
            tmp = tmp.next;
        if (tmp == null)
            return null;
        if (previous != null)
            previous.next = tmp.next;
        else
            start = tmp.next;
        this.size--;
        return tmp.data;
    }

    /**
     * Returns the size of the list.
     *
     * @return Number of elements in the list
     **/
    public int size() {
        return this.size;
    }

    /**
     * Removes all elements from the list.
     **/
    public void clear() {
        start = null;
        size = 0;
    }
}
