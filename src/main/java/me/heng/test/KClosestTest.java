package me.heng.test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * AUTHOR: wangdi
 * DATE: 2019-01-06
 * TIME: 22:36
 */
public class KClosestTest {

    static Point point = new Point(0, 0);

    public static Point[] getKClosetTest(Point[] points, int k){
        Point[] res = new Point[k];
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int diff = 0;
                diff = getDiss(o1, point) - getDiss(o2, point);
                System.out.println(diff);
                if(diff ==0){
                    diff = o1.x - o2.x;
                }
                if(diff ==0){
                    diff = o1.y-o2.x;
                }
                return diff;
            }

            public int getDiss(Point a,Point b){

                return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
//                return (int) (Math.pow((o1.x - o2.x), 2) - Math.pow((o1.y - o2.y), 2));
            }
        });

        for(Point p:points){
            queue.offer(p);
        }

        for(int i=0;i<k;i++){
            res[i] = queue.poll();
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] map = new int[][]{{4, 6}, {4, 7}, {4, 4}, {2, 5}, {-10, -20}};
        int k = 3;
        Point[] points = new Point[5];
        points[0] = new Point(map[0][0], map[0][1]);
        points[1] = new Point(map[1][0], map[1][1]);
        points[2] = new Point(map[2][0], map[2][1]);
        points[3] = new Point(map[3][0], map[3][1]);
        points[4] = new Point(map[4][0], map[4][1]);

        for(Point point:getKClosetTest(points,2)){
            System.out.println(point);
        }




    }

}

class Point{
    int x;
    int y;
    Point(){
        x=0;
        y=0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
