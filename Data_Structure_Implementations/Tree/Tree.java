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
public class Tree {
  /* Now that a TreeNode is defined, we are going to
     build a binary tree. */
  public TreeNode root;

  /* Construct an empty binary tree at the root */
  public Tree () {
    //initialize root node to null
    root = null;
  }

  public Tree (TreeNode n) {
    root = n;
  }

  /* Insert a new node in the binary tree. If the
  root node is null, create the root node now.
                                          */
  public void insertNode (int d){
    if (root == null)
      root = new TreeNode(d);
    else
      root.insert(d);
  }

  //inorder: the left node is visited first, then current node, then right node
  private void inOrderDriver(TreeNode node){
    if (node == null)
      return;
    else {
      inOrderDriver(node.left);
      System.out.print(" "+node.data+" -> ");
      inOrderDriver(node.right);
    }
  }

  //preorder: value of current node always printed, then left, then right
  private void preOrderDriver(TreeNode node){
    if (node == null)
      return;
    else {
      System.out.print(" "+node.data+" -> ");
      preOrderDriver(node.left);
      preOrderDriver(node.right);
    }
  }

  //postorder: value of left printed, then value of right printed, then given
  private void postOrderDriver(TreeNode node){
    if (node == null)
      return;
    else {
      postOrderDriver(node.left);
      postOrderDriver(node.right);
      System.out.print(node.data+" -> ");
    }
  }

  public void inOrderTraversal(){inOrderDriver(root);}
  public void preOrderTraversal(){preOrderDriver(root);}
  public void postOrderTraversal(){postOrderDriver(root);}

  public static void main(String args []){
    Tree thisTree = new Tree();
    // int i, j, k;
    // for (i=0; i<10; i++){
    //     j=(int)(100*Math.random());
    //     System.out.print(j+" ");
    //     thisTree.insertNode(j);
    // }

    thisTree.insertNode(5);
    thisTree.insertNode(6);
    thisTree.insertNode(2);
    thisTree.insertNode(1);
    thisTree.insertNode(3);
    // thisTree.insertNode(4);
    System.out.println("\n\n");

    // Traversal routines

    System.out.println("Try Inorder traversal.\n\n");
    thisTree.inOrderTraversal();
    System.out.println("\n *****************\n");
    System.out.println("Try Preorder traversal.\n\n");
    thisTree.preOrderTraversal();
    System.out.println("\n *****************\n");
    System.out.println("Try Postorder traversal.\n\n");
    thisTree.postOrderTraversal();
    System.out.println("\n");
  }
}
