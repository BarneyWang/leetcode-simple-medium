package me.heng.algorithm;

import java.util.LinkedList;

/**
 * AUTHOR: wangdi
 * DATE: 2018-12-23
 * TIME: 16:44
 */
public class MaximumDepthofBinaryTree {


    static int depthDfs(TreeNode root){
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 1; //num of nodes left in current level
        int nextNum = 0; //num of nodes in next level
       while(!queue.isEmpty()){
           TreeNode n = queue.poll();
           curNum--;
           if(n.left!=null)
           {
               queue.add(n.left);
               nextNum++;
           }
           if(n.right!=null)
           {
               queue.add(n.right);
               nextNum++;
           }
           if(curNum == 0)
           {
               curNum = nextNum;
               nextNum = 0;
               level++;
           }
       }

        return level;

    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 1; //num of nodes left in current level
        int nextNum = 0; //num of nodes in next level
        while(!queue.isEmpty())
        {
            TreeNode n = queue.poll();
            curNum--;
            if(n.left!=null)
            {
                queue.add(n.left);
                nextNum++;
            }
            if(n.right!=null)
            {
                queue.add(n.right);
                nextNum++;
            }
            if(curNum == 0)
            {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
    }


    static int depth(TreeNode treeNode){
        return treeNode == null ? 0 : Math.max(depth(treeNode.left), depth(treeNode.right)) + 1;
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
        t2.right = t4;
        System.out.println(depthDfs(root));
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
