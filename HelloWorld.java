package test;
import java.util.*;
import java.io.*;

public class HelloWorld{
    
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

