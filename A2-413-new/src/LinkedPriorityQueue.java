public class LinkedPriorityQueue<E extends Comparable<E>> extends LinkedList<E> implements PriorityQueueInterface<E> {
    @Override
    public void add(E data) {
        if (getHead() == null || getHead().getData().compareTo(data) > 0) {
            Node<E> newNode = new Node<>(data);
            newNode.setNext(getHead());
            setHead(newNode);
        } else {
            Node<E> current = getHead();
            while (current.getNext() != null && current.getNext().getData().compareTo(data) < 0) {
                current = current.getNext();
            }

            Node<E> newNode = new Node<>(data);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    @Override
    public E peek() {
        if (getHead() == null) return null;
        return getHead().getData();
    }

    @Override
    public E poll() {
        if (getHead() == null) return null;
        E data = getHead().getData();
        setHead(getHead().getNext());
        return data;
    }

    // The get(int index) and printList() methods are inherited from LinkedList and remain unchanged.
}
