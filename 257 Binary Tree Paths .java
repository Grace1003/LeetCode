// Given a binary tree, return all root-to-leaf paths.

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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<String>();
        if(root == null){
            return list;
        }
        
        String path = "";
        traverse(list, path, root);
        
        return list;
    }
    
    public void traverse(List<String> list, String path, TreeNode node){
        if(node == null){
            return;
        }
        int len = path.length();
        if(node.left == null && node.right == null){
            path += "->" + node.val;
            list.add(new String(path.substring(2,path.length())));
            path = path.substring(0, len);
            return;
        }
        
        path += "->" + node.val;
        traverse(list, path, node.left);
        traverse(list, path, node.right);
        path = path.substring(0, len);
    }
}

// 典型的DFS，注意在访问一个节点的最后有shrink过程