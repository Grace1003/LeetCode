// Given a binary tree, determine if it is a valid binary search tree (BST).

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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return true;
        }
        inorder(list, root);
        for(int i=1; i<list.size(); i++){
            if(list.get(i) <= list.get(i-1)){  //含等号，因为BST里不能有两个值相等的点
                return false;
            }
        }
        return true;
    }
    
    public void inorder(List list, TreeNode node){
        if(node == null){
            return;
        }
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }
}

// 利用BST中序遍历一定有序的原则