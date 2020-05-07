package me.heng.algorithm.linknode;

import com.alibaba.fastjson.JSONObject;

public class ReverseListNode {

  public static ListNode ReverseListNode(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    head = pre;
    return head;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(0);
    ListNode l2 = new ListNode(1);
    l1.next = l2;
    ReverseListNode(l1);
    System.out.println(JSONObject.toJSONString(l1));
  }
}

class ListNode {
  ListNode next;
  int val;

  ListNode(int val) {
    this.val = val;
  }
}