package me.heng.algorithm;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * max heap 最大堆解法 AUTHOR: wangdi DATE: 2018-12-27 TIME: 22:02
 */
public class KClosestPoint {

    private static Point origin1;

    public static List<List<Integer>> k1(int k, List<List<Integer>> m, int x) {

        return null;
    }

    public static Point[] kClosestPoint(Point[] points, Point origin, int k) {

        Point[] res = new Point[k];
        origin1 = origin;
        PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {

            @Override
            public int compare(Point a, Point b) {
                int diff = 0;
                diff = distance(a, origin1) - distance(b, origin1);
                System.out.println(diff);
                if (diff == 0) {
                    diff = a.x - b.x;
                }
                if (diff == 0) {
                    diff = a.y - b.y;
                }
                return diff;

            }
        });
        for (Point point : points) {
            queue.offer(point);
        }
        for (int i = 0; i < k; i++) {
            Point point = queue.poll();
            res[i] = point;
        }

        return res;
    }

    private static Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {

            return 0;
        }
    };
    private static Comparator<Point> comparatorDistance = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            int diff = 0;
            diff = distance(a, origin1) - distance(b, origin1);
            System.out.println(diff);
            if (diff == 0) {
                diff = a.x - b.x;
            }
            if (diff == 0) {
                diff = a.y - b.y;
            }
            return diff;

        }
    };

    private static int distance(Point a, Point b) {
        // System.out.println((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[][] map = new int[][] { { 4, 6 }, { 4, 7 }, { 4, 4 }, { 2, 5 }, { -10, -20 } };
        int k = 3;
        Point[] points = new Point[5];
        points[0] = new Point(map[0][0], map[0][1]);
        points[1] = new Point(map[1][0], map[1][1]);
        points[2] = new Point(map[2][0], map[2][1]);
        points[3] = new Point(map[3][0], map[3][1]);
        points[4] = new Point(map[4][0], map[4][1]);

        for (Point point : kClosestPoint(points, new Point(0, 0), 2)) {
            System.out.println(point);
        }

    }
}

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}
