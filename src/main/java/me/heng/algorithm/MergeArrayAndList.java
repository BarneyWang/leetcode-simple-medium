package me.heng.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1. 题目：
 * <p>
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 * <p>
 * 2. 题目
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists. AUTHOR:
 * wangdi DATE: 2019-01-07 TIME: 12:24
 */
public class MergeArrayAndList {

    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        // 创建一个dummy头，从后面开始接
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        // 依次比较拼接
        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        // 把剩余的全拼上去
        if (a == null) {
            curr.next = b;
        } else if (b == null) {
            curr.next = a;
        }
        return dummy.next;

    }

    public static int[] mergeArray(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(res.length, mergeComparator);
        for (int i = 0; i < a.length; i++) {
            queue.offer(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            queue.offer(b[i]);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = queue.poll();
        }
        return res;
    }

    public static Comparator<Integer> mergeComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    };


    public static void main(String[] args) {
        int[] a = {1, 3, 4, 7, 8};
        int[] b = {1, 5, 6};
        int[] res = mergeArray(a, b);
        System.out.println(JSONObject.toJSONString(res));
    }
}
