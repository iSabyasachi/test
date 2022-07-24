package test.string;

import java.util.*;
/**
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
Input: x = 123
Output: 321
 */
public class ReverseString{  
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static void main(String[] args) {
        //char[] chars = new char[]{'h','e','l','l','o'}; //[o, l, l, e, h]
        char[] chars = new char[]{'H','a','n','n','a','h'}; //["h","a","n","n","a","H"]
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
    
    public static void reverseString(char[] s){
        int low = 0, high = s.length - 1;
        while(low <= high){
            swap(s, low++, high--);
        }
    }
    public static void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    
    
}

