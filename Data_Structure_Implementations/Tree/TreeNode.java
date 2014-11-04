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
  public TreeNode parent;
  public int data;

  public TreeNode (int d) {
    data = d;
    left = null;
    right = null;
    parent = null;
  }

  public void setLeft(TreeNode n) {
    n.parent = this;
    this.left = n;
  }

  public void setRight(TreeNode n) {
    n.parent = this;
    this.right = n;
  }

  /* define an insert method for TreeNodes */
  public void insert(int d){
    if (d < data){
      if (left == null) {
        setLeft(new TreeNode(d));
      } else {
        left.insert(d);
      }
    }
    else if (d > data) {
      if (right == null) {
        setRight(new TreeNode(d));
      } else {
        right.insert(d);
      }
    }
  }

}

