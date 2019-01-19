package me.heng.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 49 AUTHOR: wangdi DATE: 2019-01-07 TIME: 14:33
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // if (!map.containsKey(key)) {
            // List<String> slist = new ArrayList<String>();
            // slist.add(str);
            // map.put(key, slist);
            // } else {
            // map.get(key).add(str);
            // }
            map.computeIfAbsent(key, (k) -> new ArrayList<>()).add(str);

        }
        return new ArrayList<List<String>>(map.values());
    }
}
