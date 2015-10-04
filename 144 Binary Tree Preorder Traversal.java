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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        traverse(list, root);
        return list;
    }
    
    public void traverse(List list, TreeNode node){
        if(node == null){
            return;
        }
        
        list.add(node.val);
        traverse(list, node.left);
        traverse(list, node.right);
    }
}