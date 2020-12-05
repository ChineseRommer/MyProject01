/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);//该节点值为0，指向头节点
        int length = 0;
        while(head != null){
            head = head.next;
            length++;//算出链表长度
        }

        ListNode cur = dummy;
        for(int i=0; i < length-n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return dummy.next;
    }
}