package me.heng.algorithm;

/**
 *
 *
 * AUTHOR: wangdi
 * DATE: 2018-12-23
 * TIME: 15:13
 */
public class ReverseLinkedList {


    public static ListNode reverseListIteratively(ListNode head){
        ListNode n = head;
        ListNode pre =null;
        while(n!=null){
            ListNode temp = n.next;
            n.next = pre;
            pre = n;
            n = temp;
        }
        // fix head
        head = pre;
        String s="";
//        s.cha
        return head;

    }

    public static ListNode reverseList(ListNode head){

        if(head ==null || head.next == null)
            return head;
        ListNode second = head.next;
        ListNode listNode = reverseList(second);
        second.next = head;
        head.next = null;
        return listNode;
    }






    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
//        ListNode listNode = reverseList(l1);
        ListNode listNode = reverseList(l1);
        System.out.println(listNode.toString());
    }


     static class ListNode {
         int i;
         ListNode next;
         ListNode(int i){
             this.i = i;
         }

         @Override
         public String toString() {
             return "ListNode{" +
                     "i=" + i +
                     ", next=" + next +
                     '}';
         }
     }
}
