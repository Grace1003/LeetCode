// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList list = new ArrayList();
        if(root == null){
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        boolean order = true;
        while(!queue.isEmpty()){
            LinkedList level = new LinkedList();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(order){
                    level.add(node.val);
                }else{
                    level.addFirst(node.val);
                }
            
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                } 
            }
            
            order = !order;
            list.add(level);
        }
        
        return list;
    }
}


// 还是BFS模版变形，用LinkedList装每层的数字，add()和addFirst()交替