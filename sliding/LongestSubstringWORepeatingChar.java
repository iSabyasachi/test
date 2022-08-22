package test.sliding;
/**
Given a string s, find the length of the longest substring without repeating characters.

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Algo :

1. create a sliding window that iterates over the characters of the string.
2. Stores the unique characters in a  HashMap/HashSet, make sure it does not has more than K distinct character.
3. If next element is a distinct character, compare the current length of the window with the stored longest element and move the window till 
    it reaches end of the string
 */
import java.util.*;
public class LongestSubstringWORepeatingChar{

    public static void main(String[] args) {
       String s = "abcabcbb";
       //String s = " ";
       //String s = "abcde";
       int results = lengthOfLongestSubstring(s);
       System.out.println(results);
    } 
    
    public static int lengthOfLongestSubstring(String s) {
        int longestSubStringLen = 0;
        int[] table = new int[128]; 

        int windowStart = 0;
        int windowEnd = 0;
        for(; windowEnd < s.length() ; windowEnd++){
            table[s.charAt(windowEnd)]++;
            longestSubStringLen = Math.max(longestSubStringLen, (windowEnd - windowStart));

            while(table[s.charAt(windowEnd)] > 1){
                table[s.charAt(windowStart)]--;                
                windowStart++;
            }
        }
        return Math.max(longestSubStringLen, (windowEnd - windowStart));
    }
    public static int lengthOfLongestSubstringOld(String s) {
        int longestSubStringLen = 0;
        HashMap<Character, Integer> hMap = new HashMap<>();

        int windowStart = 0;
        int windowEnd = 0;
        for(; windowEnd < s.length() ; windowEnd++){
            hMap.put(s.charAt(windowEnd),hMap.getOrDefault(s.charAt(windowEnd), 0) + 1);
            longestSubStringLen = Math.max(longestSubStringLen, (windowEnd - windowStart));

            while(hMap.get(s.charAt(windowEnd)) > 1){
                hMap.put(s.charAt(windowStart), hMap.get(s.charAt(windowStart)) - 1);
                if(hMap.get(s.charAt(windowStart)) == 0){
                    hMap.remove(s.charAt(windowStart));
                }
                windowStart++;
            }
        }
        return Math.max(longestSubStringLen, (windowEnd - windowStart));
    }
}