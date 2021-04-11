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
//     public ListNode sortList(ListNode head) {

//     }
// }


































class Solution {
    //这道题使用归并排序，就是分而治之的思想，一个链表太长不好排序，那就分成两个，两个还是太长，那就分成四个，直到
    //最后变成两个两个一组，或一个一个以组。当然最后递归回来还是要多个节点排序的，但是这样效率高哦，时间复杂度符合题意。
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {//两参数分别是头指针和尾指针
        if (head == null) {//可以看出这是一个空链表，头指针直接为null，那就返回头指针
            return head;
        }
        if (head.next == tail) {//可以看出，这是一个只有一个节点的链表，把这个节点的next设置为null，所以不用排序，直接返回头指针。
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        //先分成小块，然后再一层层地完成排序
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);//dummy:虚拟的
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;//两部分链表的头指针
        while (temp1 != null && temp2 != null) {//两部分链表头指针都不为null，说明两链表都不为空链表
            if (temp1.val <= temp2.val) {
                temp.next = temp1;//取更小的节点作为新链表的下一个节点
                temp1 = temp1.next;//如何理解这条指令？temp就是头指针，就相当于temp1这个链表的第一个节点已经被取走，
                                    //头指针直接从第二个节点开始
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;//新链表的头指针一直往后移动，一个一个地增加节点
        }
        if (temp1 != null) {//temp2链表先被取完
            temp.next = temp1;//直接把剩余的加上，因为已经排好序了
        } else if (temp2 != null) {//temp1链表先被取完
            temp.next = temp2;
        }
        return dummyHead.next;//返回新链表的另一个头指针，因为那个temp头指针已经被移动到最后面，变成尾指针了，
                                //但是这个dummyHead头指针一直没变，一直指向新链表的第一个节点
    }
}

