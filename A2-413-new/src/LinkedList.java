class LinkedList<E>{

  private Node<E> head;

  // Linked list methods to store Admins and Customers
  public void add(E data) {
    Node<E> newNode = new Node<>(data);
    newNode.next = head;
    head = newNode;
  }

  private static class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data) {
      this.data = data;
      this.next = null;
    }
  }

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
