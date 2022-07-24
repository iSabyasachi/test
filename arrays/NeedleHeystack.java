package test.arrays;

import java.util.*;

public class NeedleHeystack{  

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";       
        System.out.println(strStr(haystack, needle));
    } 
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */   
    public static int strStr(String haystack, String needle) {
        int i = 0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(0) 
                && haystack.substring(i).length() >= needle.length()
                 && haystack.substring(i, i + needle.length()).equals(needle)){
                    return i;
            }
            i++;
        }
        return -1;
    }
}

