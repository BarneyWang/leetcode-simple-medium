package me.heng.algorithm;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-23
 * TIME: 17:06
 */
public class SingleNumber {


    public static int singleNumber(int[] nums) {
        int i =0,cur=0,len=nums.length;
        for(int j=0;j<nums.length;j++){
            int temp = nums[j];
            cur=0;
            for(int x=0;x<nums.length;x++){
                if(temp == nums[x]){
                    ++cur;
                }

            }
            if(cur==1){
                return temp;
            }
        }
        return 0;
    }

    public static int singleNumberOne(int[] nums) {

        return 0;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 1, 2,4,5};
        System.out.println(singleNumber(arr));
    }
}
