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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(list, root);
        return list;
    }
    
    public void traverse(List list, TreeNode node){
        if(node == null){
            return;
        }
        traverse(list, node.left);
        list.add(node.val);
        traverse(list, node.right);
    }
}