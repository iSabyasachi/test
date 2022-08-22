package test.dynamic;
import java.util.*;

/**Dynamic Programming 
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
*/

public class ClimbingStairs {
    public static void main(String[] args){
        ClimbingStairs obj = new ClimbingStairs();
        int n = 5;
        int result = obj.climbStairs(n);        
        System.out.println(result);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public int climbStairs(int n) {
        if(n == 1) return 1;

        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 2; i < n ; i++){            
            result = first + second;
            first = second;
            second = result;
        }
        return second;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    /*
    public int climbStairs(int n) {
       int[] memo = new int[n + 1];       
       int i = 0;
       while(i < n){
            if(i == 0){
                memo[i] = 1;
            }else if(i == 1){
                memo[i] = 2;
            }else{
                memo[i] = memo[i - 1] + memo[i - 2];
            }            
            i++;
       }       
       return memo[n - 1];
    }
    */
    /**
    public int climbStairs(int n) {
       int[] memo = new int[n + 1];
       return climbStairs(0, n , memo);
    }
    public int climbStairs(int i, int n, int[] memo) {        
       if(i == n) return 1;
       else if(i > n) return 0;
       else if(memo[i] > 0) return memo[i];
        
       memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n , memo); 
       
       return memo[i];
    }*/ 
    /**
    Time Complexity O (2 ^ N)
    Space Complexity : O(N)
      
    public int climbStairsOld(int n) {
        if(n == 1) return 1;
        else if(n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }*/
}
