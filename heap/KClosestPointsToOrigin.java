package test.heap;

import java.util.*;
/**
Given an array of points in a 2D plane, find ‘K’ closest points to the origin.
Ex 1: 
Input: points = [[1,2],[1,3]], K = 1
Output: [[1,2]]
Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
The Euclidean distance between (1, 3) and the origin is sqrt(10).
Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.

Ex 2:
Input: point = [[1, 3], [3, 4], [2, -1]], K = 2
Output: [[1, 3], [2, -1]]

 */
class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin() {
    // ignoring sqrt
    return (x * x) + (y * y);
  }
}
/**
Time Complexity : O(NLog K)
Space Complexity : O(k)
 */
class KClosestPointsToOrigin {

  public static List<Point> findClosestPoints(Point[] points, int k) {
    ArrayList<Point> result = new ArrayList<>();
    PriorityQueue<Point> maxHeap = new PriorityQueue<>((h1, h2) -> h2.distFromOrigin() - h1.distFromOrigin());
    for(int i=0 ; i < points.length ; i++){
        if(i < k){
            maxHeap.add(points[i]);
        }else{
            if(maxHeap.peek().distFromOrigin() > points[i].distFromOrigin()){
                maxHeap.poll();
                maxHeap.add(points[i]);
            }
        }
    }    
    return new ArrayList<>(maxHeap);
  }

  public static void main(String[] args) {
    Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
    List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
    System.out.print("Here are the k points closest the origin: ");
    for (Point p : result)
      System.out.print("[" + p.x + " , " + p.y + "] ");
    }
    /*
    Point[] points = new Point[] { new Point(1, 2), new Point(1, 3) };
    List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 1);
    System.out.print("Here are the k points closest the origin: ");
    for (Point p : result)
      System.out.print("[" + p.x + " , " + p.y + "] ");
    }*/
}