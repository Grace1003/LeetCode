// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList list = new ArrayList();
        if(root == null){
            return list;
        }
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        traverse(list, path, root, sum, 0);
        return list;
    }
    
    public void traverse(List list, List path, TreeNode node, int sum, int currentSum){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(currentSum + node.val == sum){
                path.add(node.val);
                list.add(new ArrayList<Integer>(path));  // create an arraylist and copy @path
                path.remove(path.size() - 1);  // remove last element in @path
            }
            return;
        }
        
        path.add(node.val);
        currentSum += node.val;
        
        traverse(list, path, node.left, sum, currentSum);
        traverse(list, path, node.right, sum, currentSum);
        
        //shrink
        path.remove(path.size() - 1);
        currentSum -= node.val;
    }
}

// 此题不难，就是BFS。注意每遍历完一个点，要有shrink的过程。找到了一条满足题意的Path后，也要shrink！
// 注意复制一个现有ArrayList的方法：new ArrayList<Integer>(path);