// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
// Calling next() will return the next smallest number in the BST.
// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

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

    private ArrayList<Integer> list;
    private int index;
    
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<Integer>();
        traverse(root, list);
        this.index = 0;
    }
    
    public void traverse(TreeNode node, List list){
        if(node == null){
            return;
        }
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(list != null && index < list.size()){  //!! index<list.size()
            return true;
        }else{
            return false;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if(list != null && index < list.size()){
            return list.get(index++);
        }
        return 0;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

 // 思路：用list保存中序遍历各值，因为BST中序遍历是有序的。