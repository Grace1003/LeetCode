// Given a complete binary tree, count the number of nodes.
// 注意区别完全二叉树和满二叉树

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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        // find left height
        int leftHeight = 0;
        TreeNode left = root;
        while(left != null){
            leftHeight++;
            left = left.left;
        }
        // find right height
        int rightHeight = 0;
        TreeNode right = root;
        while(right != null){
            rightHeight++;
            right = right.right;
        }
        
        if(leftHeight == rightHeight){
            return (1<<leftHeight) - 1;  //左移位，加快Math.pow(2,x)。注意位运算优先级低于二元运算符！
        }else{  
            // divide & conquer
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount + rightCount + 1;
        }
        
    }
}

// 递归遍历每一个节点运行速度慢。
// 可以证明一个完全二叉树左右子树至少有一个是满二叉树。满二叉树的节点数是2^h-1。先判断该树是否为满二叉树，然后是的话直接返回结果，如果不是递归地求解子树。
// 这样不用遍历所有的节点。复杂度小于O(N)，比对所有点遍历复杂度要小

// Math.pow(2,x) 没有位运算来的快，可用1<<x替换。注意位运算优先级低于二元运算符。


