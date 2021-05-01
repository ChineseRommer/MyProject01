// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode head = null;
//         ListNode tail = null;
//         int sum = 0;
//         int carry = 0;

//         while(l1!=null || l2!=null){
//             // int m=0;
//             // int n=0;
//             //依次取出链表的每一个节点值
//             // if(l1 == null){
//             //      m = 0;
//             // }else{
//             //      m = l1.val;
//             //      l1 = l1.next;
//             // }
//             // if(l2 == null){
//             //      n = 0;
//             // }else{
//             //      n = l2.val;
//             //      l2 = l2.next;
//             // }
//             int m = 0;
//             if(l1 != null){
//                  m = l1.val;
//                  l1 = l1.next;//头指针后移
//              }
//              //取出l2中对应节点的值
//              int n = 0;
//              if(l2 != null){
//                  n = l2.val;
//                  l2 = l2.next;//头指针后移
//              }
            

//             sum = m+n+carry;
//             carry = sum/10;//获得进位

//             if(head == null && tail == null){
//                 head = tail = new ListNode(sum%10);
//                 //tail = tail.next;
//             }else{
//                 tail.next = new ListNode(sum % 10);
//                 tail = tail.next;
//             }
//             // if(l1 != null)
//             //  l1 = l1.next;
//             //  if(l2 != null)
//             //  l2 = l2.next;
//         }

//         if(carry != 0){
//             tail.next = new ListNode(carry);
//         }

//         return head;
//     }
// }




































class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //针对这种链表类的题，首先要定义好结果链表的头指针和尾指针
        ListNode head = null;
        ListNode tail = null;
        //定义一个变量来乘装两节点的和，定义一个变量来乘装进位
        int sum = 0;
        int carry = 0;
        //定义一个循环，来遍历相加对应两节点的值，循环直到两个链表的节点都被遍历完为止
        while(l1 != null || l2 != null){
            //取出l1中的对应节点的值
            int m = 0;
            if(l1 != null){
                m = l1.val;
                l1 = l1.next;//头指针后移
            }
            //取出l2中对应节点的值
            int n = 0;
            if(l2 != null){
                n = l2.val;
                l2 = l2.next;//头指针后移
            }
            //将两结果相加，并加上进位，然后将结果赋给结果链表的对应节点
            sum = m + n + carry;
            carry = sum / 10;//提取出进位
            //如果是第一次相加，也就说在这之前没有节点，头尾指针都还是null，则我们需要new一个链表节点，然后让头尾指针都指向这个节点
            //然后再赋值。以后尾指针后移时，我们也要不断new出新的链表节点。不能直接就next，直接next是针对本身就存在的链表的，是用来
            //遍历链表的，不是用来创建新链表的。
            if(head == null && tail == null){
                head = tail = new ListNode(sum % 10);//头尾指针同时指向这个新创建的节点，并通过有参构造器直接给节点赋值
            }else{
                tail.next = new ListNode(sum % 10);//创建一个新节点并追加到尾节点后面，并赋值
                tail = tail.next;//尾指针后移
            }
            // tail.val = sum % 10;//只保留进位之后的部分
            // tail = tail.next;//尾指针后移
        }
        //跳出循环后，应该判断最高位是否有进位
        if(carry > 0){
            //再在结果链表的尾部追加一个节点并赋值
            tail.next = new ListNode(carry);//在节点链表尾部追加节点并赋值
            tail = tail.next;//尾指针后移
        }

        return head;//返回结果链表的头指针，最后就可以顺着头指针找到所有节点并读取所有值
    }
}





