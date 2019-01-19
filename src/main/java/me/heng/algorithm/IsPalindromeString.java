package me.heng.algorithm;

import java.util.LinkedList;
import java.util.Vector;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-25
 * TIME: 16:45
 */
public class IsPalindromeString {


    /**
     * get combined str palindrome is the longest in a String
     * @param str
     * @return
     */
    public static int getPalindromeStringLongest(String str){
        int[] chars = new int[128];
        for(char c :str.toCharArray()){
            ++chars[c];
        }
        //odd
        int length=0;
        int odd=0;
        for(int i : chars){
            length += i % 2 == 0 ? i : i - 1;
            if(i%2!=0){
                odd = 1;
            }
        }
        length += odd;
        return length;
    }

    public static String getLongestPalidrome(String str){
        String longestStr = "";
        LinkedList<String> list = new LinkedList<>();
        list.sort((o1, o2) -> o1.length()>o2.length()?1:-1);
        for(int i =0;i<str.length();i++){
//            String temp = str.substring(i);
            for(int j =str.length()-1;j>i;j--){
                System.out.println(i+"j+"+j);
                String temp = str.substring(i,j);
                if (isPalindrome(temp)) {
                    list.add(temp);
                }
            }
        }
        longestStr = list.getFirst();
        return longestStr;
    }


    public static boolean isPalindrome(String str) {

        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char left = str.charAt(start);
            char right = str.charAt(end);
            if (isAlphaNumeric(left) && isAlphaNumeric(right)) {
                if (Character.toUpperCase(left) != Character.toUpperCase(right)) {
                    return false;
                }
                start++;
                end--;
            } else if (!isAlphaNumeric(left)) {
                start++;
            } else if (!isAlphaNumeric(right)){
                end--;
            }
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c) {

        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
        System.out.println(getLongestPalidrome(str));
//        System.out.println(getPalindromeStringLongest(str));
    }

}
