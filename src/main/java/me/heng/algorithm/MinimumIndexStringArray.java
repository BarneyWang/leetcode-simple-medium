package me.heng.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * AUTHOR: wangdi
 * DATE: 2018-12-26
 * TIME: 15:19
 */
public class MinimumIndexStringArray {

    public static String[] get(String[] list1,String[] list2){
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min= -1;
        List<String> list = new LinkedList<>();
//        String[] res =new String[Math.max(list1.length,list2.length)];
        for(int i =0;i<list2.length;i++){
            //
            String restaurant = list2[i];
            if(map.get(list2[i])==null){
                continue;
            }
            //same restaurant
            else{
                //有相同的
                int index = map.get(list2[i]);
                int sum = index+i;

                if(sum <min){
                    min = -1;
                    list.clear();
                }
                if(sum == min||min <0){
                    min = sum;
                    list.add(restaurant);
                }

            }

        }
        if(min <0)
            return null;
        return list.toArray(new String[list.size()]);
    }

    /**
     * ["Shogun","Tapioca Express","Burger King","KFC"]
     * ["KFC","Burger King","Tapioca Express","Shogun"]
     * @param args
     */
    public static void main(String[] args) {
        String[] str = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str1 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] str4 ={"Shogun","Tapioca Express","Burger King","KFC"};
        String[] str3 = {"KFC","Burger King","Tapioca Express","Shogun"};
        System.out.println(get(str3,str4));

    }
}
