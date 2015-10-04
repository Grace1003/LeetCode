// Invert a binary tree.
// 每个节点的左右子树调换位置

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        //divide
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        //conquer
        root.left = right;
        root.right = left;
        
        return root;
        
    }
}

// 简单的分治法