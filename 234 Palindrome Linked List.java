Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        // 1. find the middle node
        ListNode slow = head;
        ListNode fast = head;
        StringBuffer sb = new StringBuffer();
        while(fast != null && fast.next != null){ // donn't forget fast!=null => nullPointerException
            sb.append(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. get the reversed right part
        // 不需要考虑奇偶性，因为是拿整个链表和右边逆转部分比较，是否包含中间点不重要
        ListNode prev = null;
        while(slow != null){   // 模版，一定要写：当前节点不为空，返回的头结点是prev。写slow.next!=null会导致最后一个节点还未逆转就退出了循环。
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        // compare left & right part
        while(prev != null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        
        return true;
    }
}


要实现O(n)的时间复杂度和O(1)的空间复杂度，只能逆转右部链表来比较。