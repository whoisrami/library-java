package CheckSubTree;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 11/28/14
 * Dependencies:
 * - N/A
 * Description:
 * -Create an algorithm to decide if T2 is a subtree of T1.
 * Solution:
 * - N/A
 */
public class CheckSubTree {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    TreeNode tree2 = new TreeNode(2);
    tree2.insert(1);
    tree2.insert(3);
    tree2.insert(4);

    TreeNode tree3 = new TreeNode(2);
    tree3.insert(1);
    tree3.insert(3);
    tree3.insert(4);

    System.out.println(match(tree2, tree3));
    System.out.println(check(tree, tree2));
  }

  //goes through all nodes in tree one, calling match on each node that is identical with t2.root
  static boolean check(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return false;
    }

    //if node values are the same, then attempt to match subtrees
    if (t1.data == t2.data && match(t1, t2)) {
      return true;
    }

    return check(t1.left, t2) || check(t1.right, t2);
  }


  //check to see if treenode in t2 matches all nodes in t1
  static boolean match(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) { //has to be exact subtree match
      return true;
    }

    if (t1 == null || t2 == null) {
      return false;
    }

    if (t1.data != t2.data) {
      return false;
    }

    boolean left = match(t1.left, t2.left);
    boolean right = match(t1.right, t2.right);
    return left && right;
  }

}
