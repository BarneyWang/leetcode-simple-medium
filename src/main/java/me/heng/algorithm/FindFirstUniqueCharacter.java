package me.heng.algorithm;

import java.util.HashMap;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-26
 * TIME: 00:45
 */
public class FindFirstUniqueCharacter {

    public static int findFirstUniqueRightTwo(String s){
        int len = s.length(),i=0;
        int[] chars = new int[26];
        while(i<len){
            chars[s.charAt(i)-'a']++;
            i++;
        }
        i=0;
        while(i<len){
            if( chars[s.charAt(i)-'a']==1){
                return i;
            }
            i++;
        }
        return -1;
    }
    public static int findFirstUniqueRightThree(String s) {
        int len = s.length(), result = -1, i = 0;

        int[] map = new int[26]; // map char to count
        while (i < len) {
            map[s.charAt(i) - 'a']++; // put 'a' at position 0
            i++;
        }

        i = 0;
        while (i < len) {
            if (map[s.charAt(i) - 'a'] == 1)
                return i;
            i++;
        }
        return -1;
    }


    public static int findFirstUniqueRight(String s){
        char[] chars = new char[256];
        for (int i = 0; i <s.length() ; i++) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i <s.length() ; i++) {
            if(chars[s.charAt(i)]==1)
                return i;
        }
        return -1;
    }
     public static int findFirstUnique(String s){
         if(s==null||s.length()==0){
             return -1;
         }
         if(s.length()<2){
             return 0;
         }
         HashMap<Character, Integer> map = new HashMap<>();
         for(int i =0;i<s.length();i++){
             char c1 = s.charAt(i);
            if(map.get(c1)==null){
                map.put(c1, i);
            }else{

                if(map.get(c1)==0)
                    continue;
                return map.get(c1)-1;
            }

         }
         return -1;
     }

    public static void main(String[] args) {
//        System.out.println(Integer.valueOf('l')-Integer.valueOf('a'));
        String str = "cc";
        System.out.println(findFirstUniqueRightThree(str));
    }
}
