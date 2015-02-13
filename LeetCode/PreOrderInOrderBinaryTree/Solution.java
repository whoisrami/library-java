package PreOrderInOrderBinaryTree;

/**
 * Author: Alex Yang
 * Date: 1/30/15
 * Dependencies:
 * - N/A
 * Description:
 * - Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.
 * Solution:
 * - Similar to this: https://oj.leetcode.com/discuss/12179/my-accepted-java-solution
 * - Essentially, what happens is we grab the first element of the preorder array because we know that is the root.  We use this data to split the inorder array into two halves by finding that element.
 * - This is because everything on the left of the root in an inorder must be less than, everything on the right must be greater than. (if we are imagining a BST)
 *
 * - ENTER SEARCH LEFT PHASE:
 *
 * - Now, add ONE to prestart.  This is because the element directly after in the preorder traversal must be the left child. if there is one.  if there is NOT, then INSTART and INEND will cause the left side to return null. Why? when you searched for the INORDERROOT, it exited immediately or didnt find it. This implies that there are NO children to the left of the INORDERROOT position!
 *
 * - We set the bounds to search the left half of the inorder array.  We do this by searching from INSTART to INORDERROOT - 1 similar to binary search.
 *
 * - Now, finally, we recurse and do this process again.
 *
 * - ENTER SEARCH RIGHT PHASE:
 * - To recurse on the right side is a bit trickier.  Searching the right side is exactly the same as the left, but setting PRESTART properly is the tricky part.  How do we know which element in the preorder traversal is the right child for the current root?
 * - In a preorder traversal, assuming the first node is the root. All left elements will come consecutively after, then all right elements.  So, what we want to do here is to find and set PRESTART at the FIRST right element.
 *
 * - To calculate this we do PRESTART - INSTART + INORDERROOT + 1
 * - PRESTART is where we currently are.
 * - we do INORDERROOT - INSTART, this will give us JUST the offset of how many left elements were found during the inorderroot search phase.
 * - We know that we need to move the prestart pointer forward that many times to hit the first right element.
 *
 * recurse down the right, rinse and repeat!
 *
 */
public class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
    if (preStart >= preorder.length || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);

    int inOrderRoot = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == root.val) {
        inOrderRoot = i;
        break;
      }
    }

    root.left = buildTree(preorder, inorder, preStart + 1, inStart, inOrderRoot - 1);
    root.right = buildTree(preorder, inorder, preStart + (inOrderRoot - inStart) + 1, inOrderRoot + 1, inEnd);
    return root;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
    val = x;
  }
}