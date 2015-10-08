// Given a binary tree, find the maximum path sum.
// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

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
    public class ReturnType{
        int singlePath;  // the max path that starts from root, can not inclue root
        int maxPath;  // the max path in the tree
        public ReturnType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        ReturnType result = findPath(root);
        return result.maxPath;
    }
    
    public ReturnType findPath(TreeNode node){
        if(node == null){
            return new ReturnType(0, Integer.MIN_VALUE);  //恒有@singlePath>=0，但maxPath默认值应该是最小整数
        }
        
        //divide
        ReturnType left = findPath(node.left);
        ReturnType right = findPath(node.right);
        
        //conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + node.val; 
        singlePath = singlePath < 0 ? 0 : singlePath; //@singlePath can include no node => 恒有@singlePath>=0
        int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath + right.singlePath + node.val);
        
        return new ReturnType(singlePath, maxPath);
    }
}

// 分治法，只有两种情况：
// 1. 通过根的path. (1)如果左子树从左树根到任何一个Node的path大于零，可以链到root上 (2)如果右子树从右树根到任何一个Node的path大于零，可以链到root上
// 2. 不通过根的path. 这个可以取左子树及右子树的path的最大值。
// 因此，创建一个inner class，记录2个值：1. 本树的最大path。2. 本树从根节点出发到任何一个节点的最大path.

// 注意singlePath指从根开始（可以不含根）的节点值之和最大的一条路径，所以singlePath恒大于等于零，取默认值时也要注意。

