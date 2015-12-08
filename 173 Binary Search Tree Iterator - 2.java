Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.



九章解法：用全局变量stack和currentNode来控制遍历。

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode node;
    
    public BSTIterator(TreeNode root) {
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (node == null && stack.isEmpty()){
            return false;    // 1.root为空，stack也为空； 2.遍历结束，node为空，stack也全pop完
        }else{
            return true;
        }
    }

    /** @return the next smallest number */
    public int next() {
    	// 把指针指向的节点和其所有左节点压入栈
        while (node != null){  // 不是node.left
            stack.push(node);
            node = node.left;
        }
        TreeNode res = stack.pop();

        // 把指针移动到右节点。这样，下次执行next()时，会把右节点中所有左节点压入栈
        // res右节点为null也没关系，下次next()中略过while循环，直接读取stack中栈顶节点
        node = res.right;   
        
        return res.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */