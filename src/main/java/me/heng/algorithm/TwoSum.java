package me.heng.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 * <p>
 * AUTHOR: wangdi
 * DATE: 2018-12-21
 * TIME: 14:20
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for(int j=i+1;j<nums.length;j++){
                if (nums[i] + nums[j] == target) {
                    ret[0] = i ;
                    ret[1] = j ;
                }
            }
        }
        return ret;
    }


    public static int[] twoSumMap(int[] nums,int target){
        int[] ret = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                ret[0] = index;
                ret[1] = i;
                break;
            }else{
                map.put(target - nums[i], i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] target = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(target,9)));
        System.out.println(Arrays.toString(twoSumMap(target,9)));

    }
}
