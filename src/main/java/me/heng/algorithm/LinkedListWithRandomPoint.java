package me.heng.algorithm;

/**
 * Leetcode 138 A linked list is given such that each node contains an
 * additional random pointer which could point to any node in the list or null.
 * 
 * Definition for singly-linked list with a random pointer. class RandomListNode
 * { int label; RandomListNode next, random; RandomListNode(int x) { this.label
 * = x; } };
 */

public class LinkedListWithRandomPoint {

  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    // 对每个结点进行复制，把复制出来的新结点插在原结点之后
    RandomListNode node = head;
    while (node != null) {
      RandomListNode n = new RandomListNode(node.label);
      n.next = node.next;
      node.next = n;
      node = n.next;
    }
    // 根据原结点的random，给新结点的random赋值
    node = head;
    while (node != null) {
      if (node.random != null) {
        node.next.random = node.random.next;
        node = node.next.next;
      }

    }

    RandomListNode newhead = head.next;
    // 把新结点从原链表中拆分出来 split
    while (node != null) {
      RandomListNode newnode = node.next;
      node.next = newnode.next;
      if (newnode.next != null) {
        newnode.next = newnode.next.next;
      }

      node = node.next;
    }

    return newhead;
  }

}

class RandomListNode {
  int label;
  RandomListNode next, random;

  RandomListNode(int x) {
    this.label = x;
  }
}
