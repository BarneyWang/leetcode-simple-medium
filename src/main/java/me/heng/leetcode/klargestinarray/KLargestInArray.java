package me.heng.leetcode.klargestinarray;

import java.util.*;

/**
 * Leetcode 215. Kth Largest Element in an Array
 * k largest(or smallest) elements in an array
 * Question:
 * Write an efficient program for printing k largest elements in an array.
 * Elements in array can be in any order.
 * For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements
 * i.e.,k = 3 then your program should print 50, 30 and 23.
 * AUTHOR: wangdi
 * DATE: 2020/6/1
 * TIME: 11:07 AM
 * DESC:
 */
public class KLargestInArray {

    public static void solution(){

    }

    public static void kLargest(Integer[] arr, int k)
    {
        // Sort the given array arr in reverse order
        // This method doesn't work with primitive data
        // types. So, instead of int, Integer type
        // array will be used
        Arrays.sort(arr, Collections.reverseOrder());

        // Print the first kth largest elements
        for (int i = 0; i < k; i++)
            System.out.print(arr[i] + " ");
    }

    /**         x< y = -1
     *          x ==y =0
     *          x >y =1
     *     public static int compare(int x, int y) {
     *         return (x < y) ? -1 : ((x == y) ? 0 : 1);
     *     }
     * @param args
     */
    public static void main(String[] args) {

        int[] array = new int[]{1, 23, 12, 9, 30, 2, 50};
        PriorityQueue<Integer> p = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i : array) {
            p.offer(i);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(p.poll());
        }
    }
}
