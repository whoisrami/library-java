/**
 * Author: Alex Yang
 * Date: 9/1/2014
 * Dependencies: 
 *   - linkedListGeneric.java
 * Given two linked lists, where each list represents a series of digits, write code to
 * "add" the two lists together.
 *
 * E.G. (for backwards case)
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 */
class linkedListAddition<T> extends linkedListGeneric<T> {
  public static void main (String args[]) {
    //617
    linkedListAddition<Integer> list1 = new linkedListAddition<Integer>();
    list1.append(7); 
    list1.append(1);
    list1.append(6);
    
    //295
    linkedListAddition<Integer> list2 = new linkedListAddition<Integer>();
    list2.append(5); 
    list2.append(9);
    list2.append(2);

    System.out.println(list1.toString());
    System.out.println(list2.toString());

    //617 + 295 = 912
    Node<Integer> head = additionBackward(list1.root, list2.root, 0);
    linkedListAddition<Integer> sumList = new linkedListAddition<Integer>(); 
    sumList.root = head;
    System.out.println(sumList.toString());
  }

  static Node<Integer> additionBackward (Node<Integer> l1, Node<Integer> l2, int carry) {
    //base case
    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }

    int value = carry;
    if (l1 != null) {
      value += l1.data;
    } 

    if (l2 != null) {
      value += l2.data;
    }

    carry = 0;
    if (value >= 10) {
      carry = 1;
    }  
    Node<Integer> result = new Node<Integer>(value%10);

    if (l1 != null || l2 != null) {
      Node<Integer> digit = additionBackward(l1 != null ? l1.next : null, 
                                             l2 != null ? l2.next : null,
                                             carry);
       result.next = digit;
    }

    return result;
  }

  static void additionForward () {

  }
}