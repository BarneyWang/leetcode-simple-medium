package me.heng.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Leetcode 88 Given two sorted integer arrays nums1 and nums2, merge nums2 into
 * nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively. You may assume that nums1 has enough space (size that is
 * greater or equal to m + n) to hold additional elements from nums2. Example:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 *
 * Output: [1,2,2,3,5,6] AUTHOR: wangdi DATE: 2018-12-26 TIME: 16:35
 */
public class MergeTwoSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int cur, next = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(m + n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int i = 0; i < m; i++) {
            queue.offer(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            queue.offer(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = queue.poll();
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 0, 0, 0 };
        int[] b = { 2, 5, 6 };
        merge(a, 3, b, 3);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
