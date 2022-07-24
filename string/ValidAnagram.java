package test.string;

import java.util.*;
/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 */
public class ValidAnagram{  
    /**
    Time Complexity : O(N)
    Space Complexity : O(N)
     */
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
    public static boolean isAnagram(String s, String t){ 
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)+1);
        }
        for(char ch : t.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch, 0)-1);
            if(hm.get(ch) == 0){
                hm.remove(ch);
            }
        }
        System.out.println(hm);
        return hm.size()==0;
    }
    public static boolean isAnagramUsingTable(String s, String t){       
        int[] table = new int[128];  
        for(char ch : s.toCharArray()){
            table[ch]++;
        }
        for(char ch : t.toCharArray()){
            table[ch]--;
        }
        for(int num : table){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}

