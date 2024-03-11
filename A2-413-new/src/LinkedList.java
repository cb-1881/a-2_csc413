public class LinkedList<E> {
  protected Node<E> head; // Make head protected to allow subclass access

  protected static class Node<E> { // Make Node and its members accessible to subclasses
      protected E data;
      protected Node<E> next;

      protected Node(E data) { // Protected constructor
          this.data = data;
          this.next = null;
      }

      public E getData() { // Public getter for data
          return data;
      }

      public Node<E> getNext() { // Public getter for next
          return next;
      }

      public void setNext(Node<E> next) { // Public setter for next
          this.next = next;
      }
  }

  public LinkedList() {
      this.head = null;
  }

  protected Node<E> getHead() { // Protected getter for head
      return head;
  }

  protected void setHead(Node<E> head) { // Protected setter for head
      this.head = head;
  }

  // Other LinkedList methods as previously defined
  // (add, get, printList etc., unchanged, assuming they don't need direct Node access modification)}

  // Define a get(int) method inside the LinkedList class
  public E get(int index) {
    Node<E> current = head;
    int count = 0;

    while (current != null) {
      if (count == index) {
        return current.data;
      }
      count++;
      current = current.next;
    }

    // Handle index out of bounds
    throw new IndexOutOfBoundsException("Index " + index + " out of bounds.");
  }

  public void printList() {
    Node<E> iterator = head;
    while (iterator != null) {
      System.out.print(iterator.data.toString() + " ");
      iterator = iterator.next;
    }
    System.out.println();
  }
}
