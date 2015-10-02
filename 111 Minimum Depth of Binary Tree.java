// Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else if(root.left == null & root.right == null){
            return 1;
        }
        
        int leftDepth = minDepth(root.left);
        leftDepth = (leftDepth == 0) ? Integer.MAX_VALUE : leftDepth;
        int rightDepth = minDepth(root.right);
        rightDepth = (rightDepth == 0) ? Integer.MAX_VALUE : rightDepth;
        
        return Math.min(leftDepth, rightDepth) + 1;
    }

}

// divide & conquer

// 注意叶子节点的判断，如果空节点都返回0，那么父节点一旦有一个子节点为空时，父节点的深度就变成了0+1，错误。

