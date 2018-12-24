package me.heng.algorithm;

import java.util.LinkedList;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-24
 * TIME: 14:27
 */
public class ReverseBinaryTree {


    

    private static TreeNode reverseBinaryTreeRecursion(TreeNode root){
        System.out.println(root.toString());
        if(root!=null){
            helper(root);
        }
        return root;
    }

    private static void helper(TreeNode p) {
        TreeNode temp = p.left;
        p.left = p.right;
        p.right = temp;

        if(p.left!=null)
            helper(p.left);

        if(p.right!=null)
            helper(p.right);
    }

    private static TreeNode reverseBinaryTree(TreeNode root) {
        System.out.println(root.toString());
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.left!=null)
                queue.push(poll.left);
            if(poll.right!=null)
                queue.push(poll.right);
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
        }


        return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        root.right = t1;
        root.left = t2;
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t1.left = t3;
        t1.right = t4;
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t2.right = t5;
        t2.left = t6;
        System.out.println(reverseBinaryTree(root));
//        System.out.println(reverseBinaryTreeRecursion(root));

    }



}
