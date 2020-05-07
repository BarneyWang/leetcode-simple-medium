package me.heng.algorithm;

import java.util.*;

/**
 * @author wangdi
 */
public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> res = new ArrayList<>(k);
        for(Integer i :arr){
            res.add(i);
        }
        while (res.size() > k) {
            int left = Math.abs(res.get(0) - x);
            int right = Math.abs(res.get(res.size() - 1) - x);

             if (left > right) {
                res.remove(0);
            } else {
                res.remove(res.size() - 1);
            }
//            ++y;
        }
        return res;
    }


    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        Vector<Integer> res = new Vector<Integer>();
        for(Integer i :arr){
            res.add(i);
        }
        int y = 0;
        while (res.size() > k) {
            int left = Math.abs(res.get(0) - x);
            int right = Math.abs(res.get(k - 1) - x);
            if (left > right) {
                res.remove(res.firstElement());
            } else {
                res.remove(res.lastElement());
            }
            ++y;
        }
        System.out.println("xxx"+y);
        return res;
    }

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
//        List<Integer> list = findClosestElements1(new int[]{1, 2, 3, 4, 5, 6}, 1, -1);
        List<Integer> list2 = findClosestElements(new int[]{1, 2, 3, 4, 5, 6}, 4, 3);
//        list.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
}