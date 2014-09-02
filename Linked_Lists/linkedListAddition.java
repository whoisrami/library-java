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
    list1.append(6); 
    list1.append(1);
    list1.append(7);
    
    //295
    linkedListAddition<Integer> list2 = new linkedListAddition<Integer>();
    list2.append(2); 
    list2.append(9);
    list2.append(5);

    System.out.println(list1.toString());
    System.out.println(list2.toString());

    //617 + 295 = 912
    // Node<Integer> head = additionBackward(list1.root, list2.root, 0);
    // linkedListAddition<Integer> sumList = new linkedListAddition<Integer>(); 
    // sumList.root = head;
    // System.out.println(sumList.toString());

    //617 + 295 = 912
    Node<Integer> head = additionForward(list1.root, list2.root, 0);
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

  //NOTE: we could also reverse the linked list and then call additionBackward
  static Node<Integer> additionForward (Node<Integer> l1, Node<Integer> l2, int carry) {
    int sizeL1 = l1.getSize();
    int sizeL2 = l2.getSize();

    //if one list is larger than the other, pad smaller list with zeros so terms to add line up
    if (sizeL1 < sizeL2) {
      l1 = padList(l1, sizeL2 - sizeL1);
    } else {
      l2 = padList(l2, sizeL1 - sizeL2);
    }
    
    PartialSum sum = addListRecursive(l1, l2);

    //append carry in front if one left over
    if (sum.carry == 0) {
      return sum.sum;
    } else {
      Node<Integer> leftover = new Node<Integer>(1);
      Node<Integer> head = sum.sum;
      leftover.next = head;
      head = leftover;
      return head;
    }
  }

  static PartialSum addListRecursive (Node<Integer> l1, Node<Integer> l2) {
    //base case
    if (l1 == null && l2 == null) {
      return new PartialSum();
    }
    
    PartialSum sum = addListRecursive(l1.next, l2.next);

    //add the two data inside the nodes together, and carry if needed
    //set carry, if needed
    //return partial sum 
    int value = sum.carry;
    value += l1.data;
    value += l2.data;

    if(value >= 10){
      sum.carry = 1;
    } else {
      sum.carry = 0;
    }
    
    //insert result value at head of linked list to be returned
    Node<Integer> result = new Node<Integer>(value%10);
    result.next = sum.sum;
    sum.sum = result; 

    return sum;
  }

  //prepends 0's to the front of the linkedList
  static Node<Integer> padList(Node<Integer> head, int numZeros) {
    while (numZeros > 0) {
      Node<Integer> zero = new Node<Integer>(0);
      zero.next = head;
      head = zero;
      numZeros--;
    }
    return head;
  }
}

class PartialSum {
  public Node<Integer> sum = null;
  public int carry = 0;
}