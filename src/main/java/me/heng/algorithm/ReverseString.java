package me.heng.algorithm;


/**
 *  reverse string
 * AUTHOR: wangdi
 * DATE: 2018-12-20
 * TIME: 19:44
 */
public class ReverseString {


    public static String reverseString(String str) {

        if (str == null || str.length() == 0)
            throw new NullPointerException("str cant be empty");

        char[] chars = str.toCharArray();
        int right = chars.length - 1;
        for (int i = 0; i <= right; i++) {
            char swap = chars[i];
            chars[i] = chars[right];
            chars[right--] = swap;
            System.out.println(right);
        }

        return new String(chars);
    }


    public static void main(String[] args) {
        String s = reverseString("hello");
        System.out.println(s);

    }
}
