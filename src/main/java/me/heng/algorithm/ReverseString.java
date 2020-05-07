package me.heng.algorithm;

import javax.sound.sampled.SourceDataLine;

/**
 * reverse string AUTHOR: wangdi DATE: 2018-12-20 TIME: 19:44
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        helper(0, s.length - 1, s);
    }

    public static void helper(int start, int end, char[] s) {
        if (start >= end) {
            return;
        }
        // swap between the first and the last elements.
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;

        helper(start + 1, end - 1, s);
    }

    public static void main(String[] args) {
        String s = "hello";
        // String s = reverseString("hello");
        // System.out.println(s);
        char[] cs = s.toCharArray();
        reverseString(cs);
        // helper(0, cs.length - 1, cs);
        System.out.println(new String(cs));

    }
}
