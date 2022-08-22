package test.arrays;

import java.util.*;
import java.util.stream.*;
/**
Given a string s, return the longest palindromic substring in s.
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
*/
/**
Time Complexity : O(N^2)
Space Complexity : O(1)
 */
public class LongestPalindromicSubstring{  

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        //String s = "aaaa";
        String s = "babad";
        //String s = "cbbd";
        //String s ="ac";
        String result = obj.longestPalindrome(s);        
        System.out.println(result);
    }
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int length = 0;
        int start = 0 , end = 0;
        for(int i = 0 ; i < s.length() ; i++){            
            int len1 = findLongestPalindromeSubStr(s, i, i);            
            int len2 = findLongestPalindromeSubStr(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > (end - start)){
                start = i - (len - 1) /2;
                end = i  + (len / 2); 
            }               
        }
        return s.substring(start, end + 1);
    }
    
    public int findLongestPalindromeSubStr(String str, int i, int j){
        int left = i, right = j;
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }             
        return right - left - 1; 
    }

    public String longestPalindromeOld(String s) {
        String longestPalindrome = "";
        for(int i = 0 ; i < s.length() ; i++){
            String subString = findLongestPalindromeSubStrOld(s, i, i);
            longestPalindrome = subString.length() > longestPalindrome.length() ? subString : longestPalindrome;

            subString = findLongestPalindromeSubStrOld(s, i, i+1);
            longestPalindrome = subString.length() > longestPalindrome.length() ? subString : longestPalindrome;           
        }
        return longestPalindrome;
    }
    
    public String findLongestPalindromeSubStrOld(String str, int i, int j){
        int left = i, right = j;
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }        
        return str.substring(left+1, right);
    }
    
}