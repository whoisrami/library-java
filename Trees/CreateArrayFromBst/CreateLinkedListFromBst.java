package CreateArrayFromBst;

import LinkedList.Node;
import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 12/3/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class CreateLinkedListFromBst {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    Node<Integer> head = null;
    Node<Integer> prev = null;

    convert(tree, prev, head);
    while (head != null) {
      System.out.println(head.data);
      head = head.next;
    }
  }

  //TODO: this doesnt work because my treenode and linkedlist node types are different.
  static void convert(TreeNode t, Node<Integer> prev, Node<Integer> head) {
    if (t == null) return;

    convert(t.left, prev, head);

    if (prev != null) {
      t.left = new TreeNode(prev.data);
      prev.next = new Node<>(t.data);
    } else {
      head = new Node<>(t.data);
    }

    prev = new Node<>(t.data);

    convert(t.right, prev, head);
  }
}
