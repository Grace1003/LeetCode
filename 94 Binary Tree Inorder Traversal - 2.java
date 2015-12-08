Given a binary tree, return the inorder traversal of its nodes` values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){   // 结束循环条件：node和stack都为空
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            TreeNode res = stack.pop();
            list.add(res.val);
            node = res.right;
        }
        return list;
    }
}

Iterative做法，用stack来保存一系列左子结点。
方法同BST遍历那题。



