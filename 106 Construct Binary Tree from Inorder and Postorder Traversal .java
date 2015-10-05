// Given inorder and postorder traversal of a tree, construct the binary tree.
// Note: You may assume that duplicates do not exist in the tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
            return null;
        }
        
        int inorderIndex = 0;
        int postorderIndex = 0;
        for(int i = 0; i < inorder.length; i++){
            for(int j = 0; j < postorder.length; j++){
                if(inorder[i] == postorder[j] && postorderIndex < j){
                    postorderIndex = j;  
                    inorderIndex = i;
                    break;
                }
            }
        }
        
        // 1. 新建root节点，值为找到的后序遍历序列里面最后一个数
        TreeNode root = new TreeNode(postorder[postorderIndex]);

        // 2. 以root点分割先序遍历为左右两段
        int[] left = new int[inorderIndex]; // not include root
        for(int i = 0; i < left.length; i++){
            left[i] = inorder[i];
        }
        int[] right = new int[inorder.length - inorderIndex - 1];
        for(int i = 0; i < right.length; i++){
            right[i] = inorder[inorderIndex + 1 + i];
        }
        
        // 3. 分别建立左右子树后，赋值为root节点左右子树
        root.left = buildTree(left, postorder);
        root.right = buildTree(right, postorder);
        
        return root;
    }
    
    
}

// 后序遍历中，最后一个值就是root节点的值；中序遍历中，root节点左边所有数都是root左子树的值，右边所有数都是root右子树的值
// 所以，先在后序遍历数组中找到root节点的值，再把该值在中序遍历左右的数值变成两个数组，分别遍历，得到构建好的左子树和右子树。