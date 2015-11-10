A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.


九章思路：
第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  
然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`
然后第二遍copy的时候去建立边的copy， 拆分节点, 一边扫描一边拆成两个链表，这里用到两个dummy node
第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3` 


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        copyNode(head);  // 先copy节点数值
        copyRandom(head);   // 再借助copy点与原始点的关系来copy随机点
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode node = dummy;
        while(head != null){
            node.next = head.next;
            head.next = head.next.next;  // 注意要把给定的链表改回原始状态
            head = head.next;
            node = node.next;
        }
        
        return dummy.next;
    }
    
    public void copyNode(RandomListNode node){
        while(node != null){
            RandomListNode copy = new RandomListNode(node.label);
            copy.next = node.next;
            node.next = copy;
            node = node.next.next;
        }
    }
    
    public void copyRandom(RandomListNode head){
        while(head != null){
            if(head.random != null){  // 易错！看到XX.next就要注意这个XX是否为空！
                head.next.random = head.random.next;   
            }
            head = head.next.next;
        }
    }
}

另一种需要使用extra space的方法是用HashMap