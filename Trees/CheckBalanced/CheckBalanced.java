package CheckBalanced;
import Tree.Tree;
import Tree.TreeNode;

/**
 * Author: Alex Yang
 * Date: 10/26/14
 * Dependencies:
 * - N/A
 * Description:
 * - Checks height and if given tree is balanced.
 * Solution:
 * - N/A
 */

public class CheckBalanced {
  public static void main(String args[]) {
    Tree thisTree = new Tree();
    thisTree.insertNode(5);
    thisTree.insertNode(6);
    thisTree.insertNode(2);
    thisTree.insertNode(1);
    thisTree.insertNode(3);

    System.out.println(checkHeightBalanced(thisTree.root));
    System.out.println("Height of this tree: "+ treeHeight(thisTree.root) +'\n');
    System.out.println("is the tree balanced? " + isBalanced(thisTree.root)+ '\n');
  }

  static int checkHeightBalanced(TreeNode root){
    if(root == null){
      return 0; //height of 0
    }
    int leftHeight = checkHeightBalanced(root.left);
    if(leftHeight == -1){
      return -1; //not balanced
    }
    int rightHeight = checkHeightBalanced(root.right);
    if(rightHeight == -1){
      return -1; //not balanced
    }

    int heightDiff = leftHeight - rightHeight;
    if(Math.abs(heightDiff) > 1){
      return -1; //not balanced
    }else{
      return Math.max(leftHeight, rightHeight) + 1; //balanced, getheight
    }
  }

  // Compute the height of the tree recursively
  static int treeHeightDriver(TreeNode root) {
    if (root == null)
      return 0;
    else
      return Math.max(treeHeightDriver(root.left), treeHeightDriver(root.right))+1;
  }


  static int treeHeight(TreeNode root) {
    int k = checkHeightBalanced(root);
    return k;
  }


  static boolean isBalanced(TreeNode root){
    if(checkHeightBalanced(root) == -1){
      return false;
    }else{
      return true;
    }
  }
}
