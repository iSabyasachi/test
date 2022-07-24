package test.string;

import java.util.*;


public class LongestCommonPrefix{  

    public static void main(String[] args) {
        //String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{"dog","racecar","car"};        
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        PriorityQueue<String> queue = new PriorityQueue<>((s1, s2)-> s1.length() - s2.length());
        for(String str : strs){
            queue.add(str);
        }        
        String commonPrefix = queue.peek();
        
        while(commonPrefix.length() > 0){
            boolean isFound = true;
            for(String str : strs){
                if(!str.substring(0, commonPrefix.length()).equals(commonPrefix)){
                    isFound = false;                    
                }
            }
            if(isFound){
                return commonPrefix;
            }
            commonPrefix = commonPrefix.substring(0, commonPrefix.length()-1);
        }
        return commonPrefix;
    }
   
}

