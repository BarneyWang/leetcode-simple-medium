package me.heng.leetcode.maximumsubarray;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;

/**
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach,
 *
 * which is more subtle.
 * AUTHOR: wangdi
 * DATE: 2020/6/1
 * TIME: 11:23 AM
 * DESC:
 */
public class MaximumSubarray {

    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
     * 返回每次滑动窗口最大值。
     * @param nums
     * @return
     */
    static Integer[] SlidingWindowInArray(int[] nums,int k){
        //save index
        Deque<Integer> q = new ArrayDeque<>(k);
        //save value
        Vector<Integer> res = new Vector(k);
        if(nums == null || nums.length ==0){
            return null;
        }
        for (int i = 0; i < nums.length; i++) {

            while(!q.isEmpty()&&nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            //
            if(q.peekFirst()==(i-k))//满了
            {
                q.pollFirst();
            }
            if(i>=k-1)
            {
                res.addElement(nums[q.peekFirst()]);
            }
        }
        Integer[] integers = new Integer[res.size()];
        integers = res.toArray(integers);
        return integers;
    }

    static Integer maximun(int[] origin){
        Integer max =origin[0];
        Integer sum =origin[0];
        for (int i = 0; i < origin.length; i++) {
            if(sum<0){
                sum = origin[i];
            }else{
                sum += origin[i];
            }
            max= Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] integers = SlidingWindowInArray(new int[]{1, 2, 3, -1, 5}, 3);

        System.out.println(JSONObject.toJSONString(integers));
    }
}
