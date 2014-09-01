/**
 * Author: Alex Yang
 * Date: 8/30/2014
 * Dependencies: 
 *   - linkedListGeneric.java
 * Given a linked list, return the kth to last element.
 * Assuming we do not know the size of the linked list.
 *
 * I provide both iterative and recursive solutions.
 */
class linkedListKthToLast<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    linkedListKthToLast<Integer> list = new linkedListKthToLast<Integer>();
    list.append(1); 
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);;
    System.out.println(list.toString());
    System.out.println(list.kthToLastIterative(6));
    list.kthToLastRecursive(list.root, 4);
  }

  //have current node go through k iterations first
  //then have the runner node go throguh at the same time until current node hits end of list
  public T kthToLastIterative (Integer k) {
    if (k <= 0) return null;
    Node<T> current = this.root;
    Node<T> runner = this.root;

    for (int i = 0; i < k-1; i++) {
      if (current == null) {
        return null;
      }
      current = current.next;
    }

    //need extra check here, in case k passed in was 1 larger than list size
    if (current == null) return null;
    while(current.next != null) {
      current = current.next;
      runner = runner.next;
    }

    return runner.data;
  }

  public int kthToLastRecursive (Node<T> n, Integer k) {
    //base case
    if (n == null) {
      return 0;
    }

    //recurse back up list, incrementing return value until it equals to k
    int i = kthToLastRecursive(n.next, k);
    i++;
    if (i == k) {
      System.out.println("data at kth to last node recursive: " + n.data);
    }
    return i;
  }
}