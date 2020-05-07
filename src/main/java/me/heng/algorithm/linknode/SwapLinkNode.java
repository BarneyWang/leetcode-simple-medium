package me.heng.algorithm.linknode;

public class SwapLinkNode {

  public ListNode swapPairs(ListNode head) {
    swap(head);
    return head;
  }

  void swap(ListNode n) {
    if (n == null)
      return;
    if (n.next == null)
      return;
    int temp = n.val;
    n.val = n.next.val;
    n.next.val = temp;
    swap(n.next.next);
  }

  public static void main(String[] args) {

  }
}

// class ListNode {
// int val;
// ListNode next;

// ListNode(int x) {
// val = x;
// }
// }