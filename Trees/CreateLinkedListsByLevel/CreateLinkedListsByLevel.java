package CreateLinkedListsByLevel;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Author: Alex Yang
 * Date: 10/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - N/A
 * Solution:
 * - N/A
 */
public class CreateLinkedListsByLevel {
  public static void main(String args[]) {
    TreeNode tree = new TreeNode(5);
    tree.insert(6);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);

    createLevelLinkedList(tree);
    System.out.println("DFS version**********************");
    ArrayList<LinkedList<TreeNode>> lists = createLevelLinkedListDFS(tree);

    for (LinkedList<TreeNode> list : lists) {
      for (TreeNode n : list) {
        System.out.print(n.data);
      }
      System.out.println();
    }
  }

  //BFS implementation
  static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();

    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
    if (root != null) {
      current.add(root);
    }

    while (current.size() > 0) {
      results.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<TreeNode>();

      for (TreeNode parent : parents) {
        System.out.print(parent.data);
        if (parent.left != null) current.add(parent.left);
        if (parent.right != null) current.add(parent.right);
      }
      System.out.println();
    }

    return results;
  }

  //DFS Implementation
  static void createLevelLinkedListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
    if (root == null) return; //base case

    LinkedList<TreeNode> list = null;
    if (lists.size() == level) {
      list = new LinkedList<TreeNode>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }

    list.add(root);
    createLevelLinkedListDFS(root.left, lists, level + 1);
    createLevelLinkedListDFS(root.right, lists, level + 1);
  }

  static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
    createLevelLinkedListDFS(root, lists, 0);
    return lists;
  }
}

