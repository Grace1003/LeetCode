Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

链表节点从左到右，每k个节点翻转一次，最后不足k个节点则不翻转。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        
        // 1. 找到第一个要翻转的节点段，翻转区间内节点
        // 因为这个循环只移动nextHead，所以不能和下面的循环合并
        ListNode dummy = new ListNode(0);
        ListNode nextHead = head;    // 代表下一个翻转节点段的头结点，注意命名要清晰
        for(int i = 0; i < k; i++){
            if(nextHead == null){
                return head;
            }
            nextHead = nextHead.next;
        }
        dummy.next = reverse(head, nextHead);

        // 2. 继续翻转剩下的区间，用两个指针共同移动
        ListNode prev = dummy;   // 必须用prev! 否则翻转的节点段怎么连上前面的节点？
        int i = 0;
        while(nextHead != null){
            if(i == k){
                prev.next = reverse(prev.next, nextHead);
                i = 0;
            }
            prev = prev.next;
            nextHead = nextHead.next;
            i++;
        }
        if(i == k){  // 有可能nextHead刚好为null，此时最后一个区间也要翻转
            prev.next = reverse(prev.next, nextHead);
        }
        
        return dummy.next;
        
    }
    
    public ListNode reverse(ListNode head, ListNode nextHead){
        ListNode prev = nextHead;
        while(head != nextHead){  // 这里不是翻转一整个链表，而是翻转一段，需要把尾节点链到nextHead
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}

我的：只遍历一遍。先翻转第一个区间，再用两个指针翻转剩下的区间。
九章：遍历两遍。先遍历一遍得到链表长度length，计算出翻转区间的个数，再用for循环控制翻转。

此题易错的细节较多。
