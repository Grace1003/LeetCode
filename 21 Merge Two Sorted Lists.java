// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return (l1 == null) ? l2 : l1;
        }
        
        ListNode dummy = new ListNode(0);  // 返回的链表里的head来自哪个链表的节点是不明确的 => 使用dummy node
        ListNode node = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        
        node.next = (l1 == null) ? l2 : l1;  // 简单方法，不需要再遍历下去

        return dummy.next;
    }
}

