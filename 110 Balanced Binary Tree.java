Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int depth = getDepth(root);
        return (depth == -1) ? false : true;
    }
    
    public int getDepth(TreeNode node){
        if (node == null){
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if(leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1){
            return -1;    // 一旦出现子树深度差大于1的情况，所有向上的返回值都变为-1 => 返回root的值也为-1
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}