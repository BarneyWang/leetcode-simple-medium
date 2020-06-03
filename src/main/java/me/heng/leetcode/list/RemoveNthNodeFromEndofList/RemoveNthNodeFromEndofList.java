package me.heng.leetcode.list.RemoveNthNodeFromEndofList;

import me.heng.leetcode.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 * AUTHOR: wangdi
 * DATE: 2020/6/2
 * TIME: 5:47 PM
 * DESC:
 */
public class RemoveNthNodeFromEndofList {

    /**
     * ListNode dummy = new ListNode(0);
     *     dummy.next = head;
     *     ListNode first = dummy;
     *     ListNode second = dummy;
     *     // Advances first pointer so that the gap between first and second is n nodes apart
     *     for (int i = 1; i <= n + 1; i++) {
     *         first = first.next;
     *     }
     *     // Move first to the end, maintaining the gap
     *     while (first != null) {
     *         first = first.next;
     *         second = second.next;
     *     }
     *     second.next = second.next.next;
     *     return dummy.next;
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
         ListNode fast = dummy;
         ListNode slow = dummy;
         //XX i ==1 & i < n+1
        for (int i = 1; i < n+1; i++) {
            fast = fast.next;
        }
//        ListNode cur = head;
//        ListNode tail = head;
        while(fast!=null){
            fast=fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode r = removeNthFromEnd(node,2);
        System.out.println(1);
    }
}
