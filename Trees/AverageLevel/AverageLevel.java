package AverageLevel;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Author: Alex Yang
 * Date: 11/19/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class AverageLevel {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);

    averageByLevel(tree);
  }

  static void averageByLevel(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> results = new ArrayList<Integer>();
    queue.addFirst(root);

    //each time you go through its the new level's nodes
    while (!queue.isEmpty()) {
      int sum = 0;
      int i = 0;
      LinkedList<TreeNode> parent = queue;
      queue = new LinkedList<TreeNode>();

      //go through nodes at each level
      for (TreeNode t : parent) {
        sum += t.data;
        i++;
        if (t.left != null) {
          queue.addLast(t.left);
        }

        if (t.right != null) {
          queue.addLast(t.right);
        }
      }
      int avg = sum/i;
      results.add(avg);
    }

    for (int i : results) {
      System.out.println(i);
    }
  }
}
