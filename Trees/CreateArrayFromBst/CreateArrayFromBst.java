package CreateArrayFromBst;

import Tree.TreeNode;

import java.util.ArrayList;

/**
 * Author: Alex Yang
 * Date: 11/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class CreateArrayFromBst {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);

    ArrayList<Integer> list = flatten(tree);
    for (int i : list) {
      System.out.print(i);
    }
    System.out.println();
  }

  static ArrayList<Integer> flatten(TreeNode root) {
    ArrayList<Integer> arr = new ArrayList<>();
    inOrderTraversal(root, arr);
    return arr;
  }

  static void inOrderTraversal(TreeNode root, ArrayList<Integer> arr) {
    if (root == null) return;
    inOrderTraversal(root.left, arr);
    arr.add(root.data);
    inOrderTraversal(root.right, arr);
  }
}
