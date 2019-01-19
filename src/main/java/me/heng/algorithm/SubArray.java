package me.heng.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * subarray 连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。 例子说明：
 * 例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为｛3,
 * 10, -4, 7,
 * 2}。因此输出为该子数组的和 18 。 AUTHOR: wangdi DATE: 2019-01-07 T
 * ME: 11:38
 */
public class SubArray {

    public static int subArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        List<Integer> res = new ArrayList<>();
        while (i < arr.length) {
            sum += arr[i];
            res.add(arr[i]);
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                res.clear();
                sum = 0;
            }
            i++;
        }
        System.out.println(JSONObject.toJSONString(res));
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -5, 4, 5};
        System.out.println(subArray(arr));
    }
}
