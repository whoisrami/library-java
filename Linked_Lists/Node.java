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
    while(n.next != null) {
      size++;
      n = n.next;
    }
    return size;    
  }
}