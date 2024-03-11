public interface PriorityQueueInterface<E> {
    // Inserts the specified element into this priority queue.
    void add(E e);

    // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    E peek();

    // Retrieves and removes the head of this queue, or returns null if this queue is empty.
    E poll();

    // Returns the element at the specified position in this list.
    E get(int index);

    // Prints all elements in this list to the console.
    void printList();
}
