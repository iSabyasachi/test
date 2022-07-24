package test.string;

import java.util.*;
/**
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */
public class ReverseInteger{  
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static void main(String[] args) {
        int input = 123;             
        System.out.println(reverse(input));
    }
    
    public static int reverse(int x){       
        boolean isNegative = x < 0 ? true : false;
        if(isNegative)
            x = -x;
        
        int rev = 0;
        while(x > 0){
            int pop = x % 10 ;
            x /= 10;            
            if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;            
        }
        return isNegative ? -rev : rev;
    }
}

