package test.design;
import java.util.*;
/**
A Rate Limiting System can allow a maximum of n requests every t seconds, 
using an implementation similar to the sliding window algorithm.

Given two positive integers n and t, and a non-decreasing stream of integers representing the 
timestamps of requests, implement a data structure that can check if each request is allowed or not.

Input
["RateLimiter", "shouldAllow", "shouldAllow", "shouldAllow", "shouldAllow", "shouldAllow"]
[[3, 5], [1], [1], [2], [3], [8]]
Output
[null, true, true, true, false, true]
 */
public class RateLimiter{
    int n;
    int t;
    Deque<Integer> Q;
    public static void main(String[] args){
        int n = 3, t = 5;
        int timestamp = 1;
        RateLimiter obj = new RateLimiter(n, t);
        System.out.println(obj.shouldAllow(1));
        System.out.println(obj.shouldAllow(1));
        System.out.println(obj.shouldAllow(2));
        System.out.println(obj.shouldAllow(3));
        System.out.println(obj.shouldAllow(8));
    }
    public RateLimiter(int n, int t) {
        this.n = n;
        this.t = t;
        this.Q = new LinkedList<>();
    }
    
    public boolean shouldAllow(int timestamp) {
        //remove any timestamp that is less than the t - 1 second from the timestamp
        while(!Q.isEmpty() && Q.getFirst() < timestamp - t + 1){
            Q.removeFirst();
        }

        if(Q.size() < n){
            Q.addLast(timestamp);
            return true;
        }

        return false;
    }

}