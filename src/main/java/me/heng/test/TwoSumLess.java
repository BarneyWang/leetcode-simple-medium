package me.heng.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-06
 * TIME: 23:07
 */
public class TwoSumLess {

//    int twoSum5(vector<int> &nums, int target)
//    { int count = 0; if(nums.size() < 2)
//    return count;
//    sort(nums.begin(), nums.end());
//    int start = 0, end = nums.size() - 1;
//    while(start < end)
//    {
//    int temp = nums[start] + nums[end];
//    if(temp > target) end--;
//    else { count += end - start; start++; }
//    } return count; }

    void twoSum(List<plane> go,List<plane> back){
        Collections.sort(go,planeComparator);
        Collections.sort(back,planeComparator);
        
    }

    public static Comparator<plane> planeComparator = new Comparator<plane>() {
        @Override
        public int compare(plane p1, plane p2) {
            return p1.distance - p2.distance ;
        }
    };
}
class plane{
    int id;
    int distance;
    public plane(int id,int distance){
        this.id = id;
        this.distance = distance;

    }
}