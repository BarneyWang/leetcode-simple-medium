package me.heng.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-03
 * TIME: 15:57
 */
public class TwoSearchAlgorithm {



    public static void bfs(int[] ints){
        Queue<Integer> queue = new LinkedList<>();
        for(int i : ints){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            Integer integer = queue.poll();
            System.out.println("bfs"+integer);
        }
    }

    public static void dfs(int[] ints){
        Stack<Integer> stack = new Stack<>();
        for(int i :ints){
            stack.push(i);
        }

        while (!stack.isEmpty()){
            Integer integer = stack.pop();
            System.out.println("dfs"+integer);
        }

    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6};
        bfs(ints);
        dfs(ints);
    }

}
