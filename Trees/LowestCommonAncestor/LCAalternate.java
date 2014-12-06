package LowestCommonAncestor;

import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 12/4/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class LCAalternate {
  public static void main(String args[]) {
    TreeNode root = new TreeNode(5);
    root.insert(6);
    root.insert(2);
    root.insert(1);
    root.insert(3);
    root.insert(4);

    TreeNode lca = findLca(root, root.left.left, root.left.right);
    System.out.println(lca.data); //should print 2
  }

  static TreeNode findLca(TreeNode root, TreeNode t1, TreeNode t2) {
    if (root == null) return null; //base case
    if (root == t1 && root == t2) return root; //error check

    TreeNode x = findLca(root.left, t1, t2); //search left
    if (x != null && x != t1 && x != t2) { //if lca already found, return
      return x;
    }

    TreeNode y = findLca(root.right, t1, t2);
    if (y != null && y != t1 && y != t2) {
      return y;
    }

    if (x != null && y != null) {
      return root; //lca found
    } else if (root == t1 || root == t2) { //if one of the nodes  found
      return root;
    } else {
      return (x == null)? y : x;
    }
  }
}
