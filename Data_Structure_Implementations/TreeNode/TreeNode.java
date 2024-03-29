package TreeNode;

/**
 * Author: Alex Yang
 * Date: 12/23/14
 * Dependencies:
 * - N/A
 * Description:
 * - Simple implementation of a Node in a tree.
 * - Credits to original implementation go to CTCI.
 * Solution:
 * - N/A
 */

public class TreeNode {
  public static void main(String args[]) {
    TreeNode t = new TreeNode(5);
    t.insert(6);
    t.insert(2);
    t.insert(1);
    t.insert(3);
    t.print();
  }


  public int data;
  public TreeNode left;
  public TreeNode right;
  public TreeNode parent;
  private int size = 0;

  public TreeNode(int d) {
    data = d;
    size = 1;
  }

  public void setLeftChild(TreeNode left) {
    this.left = left;
    if (left != null) {
      left.parent = this;
    }
  }

  public void setRightChild(TreeNode right) {
    this.right = right;
    if (right != null) {
      right.parent = this;
    }
  }

  public void insert(int d) {
    if (d <= data) {
      if (left == null) {
        setLeftChild(new TreeNode(d));
      } else {
        left.insert(d);
      }
    } else {
      if (right == null) {
        setRightChild(new TreeNode(d));
      } else {
        right.insert(d);
      }
    }
    size++;
  }

  public int size() {
    return size;
  }

  public boolean isBST() {
    if (left != null) {
      if (data < left.data || !left.isBST()) {
        return false;
      }
    }

    if (right != null) {
      if (data >= right.data || !right.isBST()) {
        return false;
      }
    }

    return true;
  }

  public int height() {
    int leftHeight = left != null ? left.height() : 0;
    int rightHeight = right != null ? right.height() : 0;
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public TreeNode find(int d) {
    if (d == data) {
      return this;
    } else if (d <= data) {
      return left != null ? left.find(d) : null;
    } else if (d > data) {
      return right != null ? right.find(d) : null;
    }
    return null;
  }

  private static TreeNode createMinimalBST(int arr[], int start, int end){
    if (end < start) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(arr[mid]);
    n.setLeftChild(createMinimalBST(arr, start, mid - 1));
    n.setRightChild(createMinimalBST(arr, mid + 1, end));
    return n;
  }

  public static TreeNode createMinimalBST(int array[]) {
    return createMinimalBST(array, 0, array.length - 1);
  }

  public void print() {
    BTreePrinter.printNode(this);
  }
}


