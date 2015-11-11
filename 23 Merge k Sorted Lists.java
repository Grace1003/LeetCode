Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

九章思路：用最小堆（logn）找出最小的节点，然后poll()并offer()新的数进去。
用PriorityQueue实现最小堆。
需要实现Comparator。

时间复杂度：O(kn+logk)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                if(a == null){
                    return -1;
                }else if(b == null){
                    return 1;
                }else{
                    return a.val - b.val;
                }
            }
        });
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){   // 有可能这个链表头指针为null
                heap.offer(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(!heap.isEmpty()){
            ListNode min = heap.poll();
            node.next = min;
            if(min.next != null){
                heap.offer(min.next);  // 向heap放入最小节点后面的节点，保证k个链表的最小节点(最前面的节点)同时在heap中
            }
            node = node.next;
        }
        
        return dummy.next;
    }
}



