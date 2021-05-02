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
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0, head);//该节点值为0，指向头节点
//         int length = 0;
//         while(head != null){
//             head = head.next;
//             length++;//算出链表长度
//         }

//         ListNode cur = dummy;
//         for(int i=0; i < length-n; i++){
//             cur = cur.next;
//         }
//         cur.next = cur.next.next;

//         return dummy.next;
//     }
// }

// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         ListNode dummy = new ListNode(0, head);
//         ListNode first = head;
//         ListNode second = dummy;
//         for (int i = 0; i < n; ++i) {
//             first = first.next;
//         }
//         while (first != null) {
//             first = first.next;
//             second = second.next;
//         }
//         second.next = second.next.next;
//         ListNode ans = dummy.next;
//         return ans;
//     }
// }



























class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //首先要定义一个新的节点，该节点的next指针指向原链表的head节点（头节点）
        ListNode listNode = new ListNode();
        listNode.next = head;//为什么要定义这样一个新的节点，这是为了防止只有一个节点的链表删除不了元素
        //定义两个指针，作为前后指针,前者指向头节点，后者指向首节点
        ListNode first = head;
        ListNode second = listNode;
        //前指针先走n步
        for(int i = 0; i < n; i++){
            first = first.next;
        }
        //前后指针一起向右走，直到前指针到达链表尾部，这是后指针恰好处在要删除的节点的前面
        while(first != null){
            first = first.next;//加入链表长度是5，删除倒数第2个，那么前指针会一直移动到第6个节点的位置，也就是空节点的位置才会跳出循环
            second = second.next;
        }
        //修改链表
        second.next = second.next.next;

        //返回被改变后的链表
        return listNode.next;
    }
}

