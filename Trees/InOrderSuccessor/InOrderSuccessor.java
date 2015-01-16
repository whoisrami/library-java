package InOrderSuccessor;

import Tree.TreeNode;
import Tree.Tree;
/**
 * Author: Alex Yang
 * Date: 11/28/14
 * Dependencies:
 * - N/A
 * Description:
 * - Write an algorithm to find the 'next' node of a given node in a binary search tree.
 * Solution:
 * - N/A
 */
public class InOrderSuccessor {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    tree.insert(8);
    tree.insert(7);

    Tree thisTree = new Tree();
    thisTree.insertNode(5);
    thisTree.insertNode(6);
    thisTree.insertNode(2);
    thisTree.insertNode(1);
    thisTree.insertNode(3);
    thisTree.insertNode(4);
    thisTree.insertNode(8);
    thisTree.insertNode(7);

    thisTree.inOrderTraversal();

    //TreeNode successor = findNext(tree.right);
    //System.out.println(successor.data);
  }

  static TreeNode findNext(TreeNode n) {
    if (n.right != null) {
      n = n.right;
      while (n.left != null) {
        n = n.left;
      }
      return n;
    } else {
      while (n.parent != null) {
        if (n.parent.left == n) { //check if you are going up from the left
          break;
        }
        n = n.parent;
      }
      return n.parent;
    }
  }
}
