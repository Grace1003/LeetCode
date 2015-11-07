Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

链表节点向右移动k位

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        
        // get the length of list
        ListNode node = head;
        int len = 1;
        while(node.next != null){   // 让node指向最后一个节点，便于翻转后连接上head (node.next=head)
            len++;
            node = node.next;
        }
        
        // 注意题中只限定了k>=0的条件
        k = k % len;
        if(k == 0 || k == len){
            return head;
        }
        
        // find the (i-k)th node
        ListNode tail = head;  // 命名用词
        for(int i = 1; i < len - k; i++){
            tail = tail.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = tail.next;
        tail.next = null;

        node.next = head;  // join two parts
        
        return dummy.next;
        
    }
}

