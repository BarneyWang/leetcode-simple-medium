package me.heng.leetcode.list;

import me.heng.fundamental.MyLinkedList;
import me.heng.leetcode.ListNode;

/**
 * AUTHOR: wangdi
 * DATE: 2020/6/2
 * TIME: 5:17 PM
 * DESC:
 */
public class LinkedListCycle {

    /**
     * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * To represent a cycle in the given linked list,
     * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
     * If pos is -1, then there is no cycle in the linked list.
     *
     * Note: Do not modify the linked list.
     *  Linked List Cycle II
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if(head ==null ||head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){

            if(fast ==null||fast.next==null){
                return null;
            }

            if(slow==fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    /**
     * Linked List Cycle
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        ListNode r = detectCycle(node);
    }
}

