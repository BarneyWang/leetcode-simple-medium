package me.heng.algorithm;

/**
 * https://leetcode.com/problems/reorder-list/ AUTHOR: wangdi DATE: 2019-03-18
 * TIME: 11:53
 */
public class ReorderList {

    public static LinkedNode reverseList(LinkedNode head) {
        LinkedNode cur = head;
        LinkedNode prev = null;
        while (cur != null) {
            LinkedNode then = cur.next;
            cur.next = prev;
            prev = cur;
            cur = then;
        }
        // head = prev;
        return prev;
    }

    public static void merge(LinkedNode head1, LinkedNode head2) {
        LinkedNode cur1 = head1;
        LinkedNode cur2 = head2;
        while (cur1 != null) {
            LinkedNode then1 = cur1.next;
            LinkedNode then2 = cur2.next;

            cur1.next = cur2;
            cur2.next = then1;
            if (then2 == null)
                break;
            cur1 = then1;
            cur2 = then2;

        }
    }

    public static void reorderList(LinkedNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LinkedNode quick = head;
        LinkedNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;

        }

        LinkedNode l1 = head;
        LinkedNode l2 = slow.next;
        slow.next = null;

        LinkedNode head2 = reverseList(l2);
        merge(l1, head2);

        // LinkedNode pre = slow;//3
        // LinkedNode preTemp = slow.next;//4
        //
        // while(preTemp.next!=null){
        // LinkedNode current = preTemp.next; // current = 5
        //
        // preTemp.next = current.next; //4 -> next = 6
        // current.next = pre.next; // 5-> next =4
        // pre.next = current; //4 ->next =5;
        // System.out.println(preTemp.value);
        // }

        System.out.println(head.next.value);
    }

    public ListNode reverseList2(ListNode listNode) {

        ListNode cur = listNode;
        ListNode prev = null;

        while (cur.next != null) {
            ListNode then = cur.next;
            cur.next = prev;

            prev = cur;
            cur = then;
        }

        return prev;
    }

    public void reverseList3(ListNode node) {
        ListNode cur = node;
        ListNode prev = null;

        while (cur.next != null) {
            ListNode then = cur.next;
            cur.next = prev;

            prev = cur;
            cur = then;

        }
    }

    public static void main(String[] args) {
        LinkedNode l1 = new LinkedNode(1);
        LinkedNode l2 = new LinkedNode(2);
        LinkedNode l3 = new LinkedNode(3);
        LinkedNode l4 = new LinkedNode(4);
        LinkedNode l5 = new LinkedNode(5);
        LinkedNode l6 = new LinkedNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        // reorderList(l1);
        reorderList(l1);
    }
}

class LinkedNode {

    LinkedNode next;
    Integer value;

    public LinkedNode(Integer value) {
        this.value = value;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}