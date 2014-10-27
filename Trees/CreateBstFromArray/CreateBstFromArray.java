package CreateBstFromArray;
import Tree.TreeNode;
import Tree.Tree;

/**
 * Author: Alex Yang
 * Date: 10/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 * Solution:
 * - N/A
 */
public class CreateBstFromArray {
  public static void main(String args[]) {
    int[] array = {1,2,3,4,5,6,7,8};

    TreeNode n = createBst(array);
    Tree tree = new Tree(n);

    tree.inOrderTraversal();
  }

  static TreeNode createBst(int[] array) {
    return createBst(array, 0, array.length - 1);
  }

  static TreeNode createBst(int[] arr, int start, int end) {
    if (end < start) {
      return null;
    }

    int mid = (start + end)/2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = createBst(arr, start, mid - 1);
    node.right = createBst(arr, mid + 1, end);
    return node;
  }
}
