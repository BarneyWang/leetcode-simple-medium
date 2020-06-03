package me.heng.fundamental;


/**
 * AUTHOR: wangdi
 * DATE: 2020/6/1
 * TIME: 5:16 PM
 * DESC:
 */
public class MyLinkedList {
    /** Initialize your data structure here. */
    int length;
    ListNode head;

    class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }


    /** Initialize your data structure here. */
    public MyLinkedList() {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        head = node;
        length =4;

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index <0||index >length)
            return -1;
        ListNode next = head;
        while(next!=null){
            if(index==0) {
                return next.val;
            }
            index--;
            next = next.next;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head;
        head = listNode;
        this.length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val);
        ListNode next = head;
        while(next.next!=null){
            next = next.next;
        }
        next.next = listNode;
        this.length++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>=length||index <0){
            return;
        }
        ListNode listNode = new ListNode(val);
        ListNode next = head;
        ListNode tempNode = null;
        int temp = 0;
        while(next!=null){
            if(temp==index){
                tempNode=next.next;
                next.next = listNode;
                listNode.next = tempNode;
                length++;
                return;
            }
            next = next.next;
            temp++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index>=length||index <0){
            return;
        }
        ListNode next = head;
        ListNode tempNode = null;
        int temp = 0;
        int pre = index-1;
        if(pre<0){
            tempNode = head.next;
            head = tempNode;
            length--;
            return;
        }
        while(next.next!=null){
            if(temp==pre){
                tempNode=next.next.next ;
                next.next=tempNode;
                length--;
                return;
            }
            next = next.next;
            temp++;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();

     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(3);
        System.out.println(param_1);
        int param_2 = obj.get(0);
        System.out.println(param_2);
        int val = 6;
        obj.addAtHead(val);
        val=7;
        obj.addAtTail(val);
        obj.addAtIndex(2,8);
        obj.deleteAtIndex(1);
        System.out.println(1);
    }
}

