package Tree;

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
public class TreeNode {
  public TreeNode left;
  public TreeNode right;
  int data;

  public TreeNode (int d) {
    data = d;
    left = null;
    right = null;
  }
  /* define an insert method for TreeNodes */
  public void insert(int d){
    if (d < data){
      if (left == null) {
        left = new TreeNode(d);
      } else {
        left.insert(d);
      }
    }
    else if (d > data) {
      if (right == null) {
        right = new TreeNode(d);
      } else {
        right.insert(d);
      }
    }
  }
}

