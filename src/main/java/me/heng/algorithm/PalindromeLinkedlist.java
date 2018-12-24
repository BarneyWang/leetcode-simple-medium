package me.heng.algorithm;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-23
 * TIME: 16:26
 */
public class PalindromeLinkedlist {

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;

        ListNode cur = head;
        int length = 0;
        while(cur!=null){
            cur = head.next;
            length++;
        }
        cur = head;
        int[]arr=new int[length];
        for(int i =0;i<length;i++){
            arr[i] = cur.val;
            cur = cur.next;
        }
        for(int i = 0;i<length/2;i++){
            if(arr[i] != arr[length -i -1]){
                return false;
            }
        }
        return true;
    }
}
