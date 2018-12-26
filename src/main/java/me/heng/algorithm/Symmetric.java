package me.heng.algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * AUTHOR: wangdi
 * DATE: 2018-12-23
 * TIME: 17:47
 */
public class Symmetric {


    public static boolean isSymmetricBFS(TreeNode root){

        return false;
    }


    public static boolean isSymmetric(TreeNode root) {
       if(root!=null&&root.left!=null&&root.right!=null){
            if(root.left.val == root.left.val){
                return isMirrorTree(root.left,root.right);
            }else{
                return false;
            }
       }else if(root !=null&&root.left==null&&root.right==null){

           return true;
        }else if(root ==null){
           return true;
       }

       return false;
    }

    private static boolean isMirrorTree(TreeNode left,TreeNode right) {
        if(left!=null&&right!=null&& left.val == right.val){
            return isMirrorTree(left.left, right.right);
        }else if (left==null && right == null) {
            return true;
        }
        return false;
    }


    public static boolean isSymmetic(TreeNode root){
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2= new LinkedList<>();
        queue1.push(root.left);
        queue2.push(root.right);
        boolean isSymmetric = true;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode t1 = queue1.poll();
            TreeNode t2 = queue2.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue1.push(t1.left);
            queue1.push(t1.right);
            queue2.push(t2.right);
            queue2.push(t2.left);

        }
        return isSymmetric;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        root.right = t1;
        root.left = t2;
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        t1.left = t3;
        t1.right = t4;
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(3);
        t2.left = t5;
        t2.right = t6;


//        System.out.println(isSymmetric(root));
        System.out.println(isSymmetic(root));

    }

}
