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
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode prehead = new ListNode(-1);
//         ListNode pre = prehead;
//         while(l1 != null && l2 != null){
//             if(l1.val < l2.val){
//                 pre.next = l1;
//                 l1 = l1.next;
//             }
//             else{
//                 pre.next = l2;
//                 l2 = l2.next;
//             }
//             pre = pre.next;
//         }
//         //这里要考虑有一个链表先被遍历完的情况
//         pre.next = l1==null ? l2 : l1;//l1先被遍历完。则直接将pre指向l2的剩余链表部分
//         return prehead.next;
//     }
// }










class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //定义一个新的节点
        ListNode ansList = new ListNode();
        //定义一个指针，用来拼接新链表的各个节点
        ListNode prehead = ansList;
        //循环遍历
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prehead.next = l1;
                prehead = prehead.next;
                l1 = l1.next;
            }else{
                prehead.next = l2;//拼接节点
                prehead = prehead.next;//指针移动
                l2 = l2.next;
            }
        }
        //万一有一条链表先遍历完
        if(l1 == null && l2 != null){
            prehead.next = l2;
        }
        if(l1 != null && l2 == null){
            prehead.next = l1;
        }

        return ansList.next;
    }
}