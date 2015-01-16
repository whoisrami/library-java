package Diameter;

import TreeNode.TreeNode;

/**
 * Author: Alex Yang
 * Date: 1/16/15
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class Diameter {

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(10);
    tree.insert(11);
    tree.insert(5);
    tree.insert(1);
    tree.insert(3);
    tree.insert(4);
    tree.insert(6);
    tree.insert(2);
    tree.insert(7);
    tree.insert(8);

    tree.print();
    System.out.println(getHeight(tree));
    System.out.println(findDiameter(tree));
  }

  public static int findDiameter(TreeNode root) {
    if (root == null) return 0;

    int left = getHeight(root.left);
    int right = getHeight(root.right);
    int diameter = left + right + 1;

    int l_diameter = findDiameter(root.left);
    int r_diameter = findDiameter(root.right);

    return Math.max(diameter, Math.max(l_diameter, r_diameter));
  }

  public static int getHeight(TreeNode root) {
    if (root == null) return 0;

    int left = 1 + getHeight(root.left);
    int right = 1 + getHeight(root.right);
    return Math.max(left, right);
  }
}
