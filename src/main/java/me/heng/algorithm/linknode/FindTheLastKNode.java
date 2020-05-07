package me.heng.algorithm.linknode;

/**
 * to be continue
 * 查找倒数K的值
 * AUTHOR: wangdi
 * DATE: 2020/5/7
 * TIME: 12:14 PM
 * DESC:
 */
public class FindTheLastKNode {


    /**
     * time complexity = O(m) = 1
     * space complexity = O(1)
     * @param first
     * @param k
     * @return
     */
    public static ListNode findTheLastKNode(ListNode first,int k ){

        ListNode res = null;
        ListNode m =first,n=null,temp=first;
        for (int i = 0; i < k; i++) {
            temp = temp.next;
            n = temp;
        }
        while(n.next!=null){
            m = m.next;
            n = n.next;
        }
        return m;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        ListNode x = findTheLastKNode(node, 0);
        System.out.println(x.val);
    }
}
