// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
// Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        
        int leftCount = count(root.left);
        if(leftCount == k - 1){  //find the kth node
            return root.val;
        }else if(leftCount >= k){ // kth node in the left subtree
            return kthSmallest(root.left, k);
        }else{ //kth node in the right subtree
            return kthSmallest(root.right, k - leftCount - 1);  // k-(leftCount+1) 要加1，因为还要算上父节点
        }
        
    }
    
    public int count(TreeNode node){  //用分治法获得node为根的这个树里节点个数
        if(node == null){
            return 0;
        }
        //divide & conquer
        return count(node.left) + count(node.right) + 1;
    }
}

// 1、计算左子树元素个数left。
// 2、left+1 = K，则根节点即为第K个元素；left >=k, 则第K个元素在左子树中；left +1 <k, 则转换为在右子树中，寻找第K-left-1元素。


// 此题辅助函数只是用于计算树的节点个数，递归调用的则是kthSmallest函数