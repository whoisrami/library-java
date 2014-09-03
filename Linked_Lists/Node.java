class Node<T> {
  Node<T> next = null;
  T data;

  public Node (T value) {
    this.data = value;
  }

  public Node<T> next () {
    return this.next;
  }

  public T value () {
    return this.data;
  }

  public void setNext (Node<T> elem) {
    this.next = elem;
  } 

  public void setValue (T value) {
    this.data = value;
  }

  public int getSize () {
    int size = 0;
    Node<T> n = this;
    while(n != null) {
      size++;
      n = n.next;
    }
    return size;    
  }

  //loops through starting from head, and appends at the very end
  void append (T data) {
    Node<T> tail = new Node<T>(data);
    Node<T> n = this;

    while (n.next != null) {
      n = n.next;
    }
    n.next = tail;
  }

  //overrides toString method to print out contents of linked list
  public String toString () {
    StringBuilder output = new StringBuilder();
    Node<T> tempNode = this;
    while(tempNode.next != null) {
      output.append(tempNode.data).append(", ");
      tempNode = tempNode.next;
    }
    output.append(tempNode.data);
    return output.toString();
  }
}