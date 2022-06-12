package test.sliding;
/**
Given a string, find the length of the longest substring in it with no more than K distinct characters.
Ex 1: 
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Ex 2:
Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Algo :

1. create a sliding window that iterates over the characters of the string.
2. Stores the unique characters in a  HashMap/HashSet, make sure it does not has more than K distinct character.
3. If next element is a distinct character, compare the current length of the window with the stored longest element and move the window till 
    it reaches end of the string
 */
import java.util.*;
public class LongestSubstring{

    public static void main(String[] args){
        System.out.println("Hello LongestSubstring!!!");
        String input = "araaci";
        int K = 2;    
        System.out.println("The Longest Substring is "+findLongestSubString(input, K));
    }
    
    public static int findLongestSubString(String input, int K){
        int longestSubstring = 0;
        int  windowStart = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();       
        for(int windowEnd = 0 ; windowEnd < input.length() ; windowEnd++){
            charMap.put(input.charAt(windowEnd), charMap.getOrDefault(input.charAt(windowEnd), 1));
            while(charMap.size() > K){
                System.out.println(" "+input.substring(windowStart, windowEnd));
                longestSubstring = Math.max(longestSubstring, input.substring(windowStart, windowEnd).length());
                if(charMap.containsKey(input.charAt(windowStart))){
                    if(charMap.get(input.charAt(windowStart)) > 1){
                        charMap.put(input.charAt(windowStart), charMap.get(input.charAt(windowStart)) - 1);
                    }else{
                        charMap.remove(input.charAt(windowStart));
                    }
                }                               
                windowStart++;
            }
        }
        return longestSubstring;
    }
    

}