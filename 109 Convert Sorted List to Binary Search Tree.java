Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode node = head;
        int len = 0;
        while(node != null){
            node = node.next;
            len++;
        }
        return getMiddleNode(head, 0, len - 1);
    }
    
    public TreeNode getMiddleNode(ListNode head, int start, int end){
        if(start > end){
            return null;
        }
        
        int mid = start + (end - start) / 2;
        ListNode node = head;
        for(int i = 0; i < mid; i++){
            node = node.next;
        }
        
        TreeNode midNode = new TreeNode(node.val);
        midNode.left = getMiddleNode(head, start, mid - 1);
        midNode.right = getMiddleNode(node.next, 0, end - mid - 1);   // 或者(node, 1, end - mid)。不要用head，会导致超时。
        
        return midNode;
    } 
}

DFS
找中点，转化为🌲的节点，然后递归得左右子树。
注意midNode.right递归用getMiddleNode()时，不要继续用head当做头指针，会增加时间复杂度。