package me.heng.algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.Queue;

/**
 定义一个二维数组： 
 int maze[5][5] = {
     0, 1, 0, 0, 0,
     0, 1, 0, 1, 0,
     0, 0, 0, 0, 0,
     0, 1, 1, 1, 0,
     0, 0, 0, 1, 0,
 };
 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。 

 * AUTHOR: wangdi
 * DATE: 2019-01-03
 * TIME: 16:50
 */
public class Maze {


    public static boolean escapeMaze(int[][] maze,int[] start,int[] destination){
        if(maze.length == 0 && maze[0].length==0){
            return false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();

        int rowLen = maze.length;
        int colLen = maze[0].length;
        queue.offer(start[0]);
        queue.offer(start[1]);
        while(!queue.isEmpty()){
            int i = queue.poll();
            int j = queue.poll();
            if(i<0||j<0||j==colLen|| i==rowLen)
                continue;
            int temp = maze[i][j];
            if(temp == 1 || temp ==3) {
                continue;
            }
            if(i==destination[0]&&j==destination[1]){
                maze[i][j]=9;
                return true;
            }
            maze[i][j]=3;
            queue.offer(i);
            queue.offer(j - 1);
            queue.offer(i);
            queue.offer(j + 1);
            queue.offer(i - 1);
            queue.offer(j);
            queue.offer(i + 1);
            queue.offer(j);
        }
        return false;
    }


    public static boolean escapeMaze(int[][] maze){

        Queue<Integer> queue = new LinkedList<Integer>();

        int rowLen = maze.length;
        int colLen = maze[0].length;
        queue.offer(0);
        queue.offer(0);
        while(!queue.isEmpty()){
            int i = queue.poll();
            int j = queue.poll();
            if(i < 0|| j < 0||j == colLen|| i == rowLen)
                continue;
            int temp = maze[i][j];
            if(temp == 1) {
                continue;
            }
            if(i==4&&j==4){
                maze[i][j]=9;
                return true;
            }
            maze[i][j]=3;
            queue.offer(i);
            queue.offer(j - 1);
            queue.offer(i);
            queue.offer(j + 1);
            queue.offer(i - 1);
            queue.offer(j);
            queue.offer(i + 1);
            queue.offer(j);
        }
        return false;
    }


    public static void main(String[] args) {
//        int[][] maze = {{0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 1,1, 0}, {0, 0, 0, 1, 0}};
////        boolean b = escapeMaze(maze);
////        System.out.println(b);
////        System.out.println(JSONObject.toJSONString(maze));
        int[][] maze2 = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0,1, 1}, {0, 0, 0, 0, 0}};
        boolean b1 = escapeMaze(maze2, new int[]{0, 4}, new int[]{3, 2});
        System.out.println(b1);
        System.out.println(JSONObject.toJSONString(maze2));
    }
}
