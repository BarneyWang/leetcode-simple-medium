package me.heng.algorithm.treenodeexercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.alibaba.fastjson.JSON;

public class PreorderTraversal {

  public static List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<Integer> r = new ArrayList<>();
    helpPre(root, r);
    return r;
  }

  public static List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return null;
    }
    List<Integer> r = new ArrayList<>();
    helpIn(root, r);
    return r;
  }

  public static List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> r = new ArrayList<>();
    helpPost(root, r);
    return r;
  }

  private static void helpPost(TreeNode root, List<Integer> r) {
    if (root.left != null) {
      helpPost(root.left, r);
    }
    if (root.right != null) {
      helpPost(root.right, r);
    }
    r.add(root.val);

  }

  static void helpPre(TreeNode root, List<Integer> r) {
    r.add(root.val);
    if (root.left != null) {
      helpPre(root.left, r);
    }
    if (root.right != null) {
      helpPre(root.right, r);
    }
  }

  static void helpIn(TreeNode root, List<Integer> r) {
    if (root.left != null) {
      helpIn(root.left, r);
    }
    r.add(root.val);
    if (root.right != null) {
      helpIn(root.right, r);
    }

  }

  /**
   * Bread-first sreach
   * 
   * @param root
   * @return
   */
  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> r = new ArrayList<List<Integer>>();
    if (root == null) {
      return r;
    }
    LinkedList<TreeNode> q = new LinkedList<TreeNode>();
    LinkedList<TreeNode> levelqueue = new LinkedList<TreeNode>();
    q.push(root);
    while (!q.isEmpty()) {
      List<Integer> tl = new ArrayList<Integer>();
      while (!q.isEmpty()) {
        levelqueue.push(q.poll());
      }
      while (!levelqueue.isEmpty()) {
        TreeNode temp = levelqueue.poll();
        tl.add(temp.val);
        if (temp.left != null)
          q.push(temp.left);
        if (temp.right != null)
          q.push(temp.right);
      }
      r.add(tl);
    }

    return r;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(0);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode5 = new TreeNode(5);
    treeNode.left = treeNode1;
    treeNode.right = treeNode2;
    treeNode1.left = treeNode3;
    treeNode2.left = treeNode5;
    List<Integer> l = postorderTraversal(treeNode);
    // List<Integer> l2 = inorderTraversal(treeNode);
    System.out.println(JSON.toJSONString(l));
    // System.out.println(JSON.toJSONString(l2));
  }
}