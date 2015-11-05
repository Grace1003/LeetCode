Given a linked list, remove the nth node from the end of list and return its head.

For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;  
        for(int i = 0; i < n; i++){
            head = head.next;
        }
        
        while(head != null){
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next; 
        
        return dummy.next;
    }
}


如果用两个节点，后面的节点指向要删除的点，可能出现以下问题：
1. 有可能要删除最后一个点（最后一个节点node=null，并不能真正意义上删除一个节点)  =>  preDelete节点方便解决，直接给preDelete.next赋新值
2. 有可能删第一个点（返回哪个节点呢？） =>  用dummy node

