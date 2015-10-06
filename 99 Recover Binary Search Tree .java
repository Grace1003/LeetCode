// Two elements of a binary search tree (BST) are swapped by mistake.
// Recover the tree without changing its structure.
// Note: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE); //global variable
    
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        traverse(root);
        //swap two elements' value
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void traverse(TreeNode node){
        if(node == null){
            return;
        }
        traverse(node.left);
        if(first == null && node.val < prev.val){
            first = prev;
        }
        if(first != null && node.val < prev.val){
            second = node;
        }
        prev = node;
        traverse(node.right);
    }
}


// 还是通过中序遍历找点，但是为了实现O(1)的空间复杂度，只用一个prev点记录前一个点
// 参考：http://blog.sina.com.cn/s/blog_eb52001d0102v1z3.html