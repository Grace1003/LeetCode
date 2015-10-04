// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

/*
 *        _______6______
 *       /              \
 *    ___2__          ___8__     每次conquer时，都是在同一个level对其左右子树的判断
 *   /      \        /      \
 *   0      _4       7       9   例如0和5，2的left返回0这个节点、right返回5这个节点，conquer之后返回root即2
 *         /  \					 例如2和9，6的left返回2这个节点（并且左子树找到2之后就不去找2的子树了，直接返回2），6的right返回9这个节点（DFS遍历到9后逐层返回），conquer之后返回root即6
 *         3   5				 例如4和5，2的left返回null，2的right返回4（找到4后就不继续往下找了），2返回4这个节点给6，4就是LCA
 */

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	// efficient method 同时判断root为空或者等于其中某个点
        if(root == null || root == p || root == q){   // 找到一个点，立即返回此点
            return root;
        }
        
        //divide  
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //conquer  所有能执行到这里的情况，left和right分别代表了root的左右子树是否含有p或者q
        if(left != null && right != null){  // 两个点分别在root的左右子树上，LCA就是root
            return root;
        }else if(left != null){ 
            return left;
        }else if(right != null){
            return right;
        }else{
            return null;
        }
    }
}

// 分治法
// 只有三种情况：1.没有LCA，2. 其中一个点就是LCA，3. 两个点分别在他们LCA的左右两个子树上