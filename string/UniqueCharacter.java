package test.string;

import java.util.*;
/**
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
public class UniqueCharacter{  
    /**
    Time Complexity :
    Space Complexity :
     */
    public static void main(String[] args) {
        //String str = "leetcode";
        //String str = "loveleetcode";
        //String str = "aabb";
        String str = "loveleetcode";
        System.out.println(firstUniqChar(str));
    }
    
    public static int firstUniqChar(String s){         
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), -1);
            else
                map.put(s.charAt(i), i);                        
        }
        if(map.values().size() == 0)
            return -1;
        
        List<Integer> values = new ArrayList<>(map.values());
        for(int j = 0; j < values.size() ; j++){
            if(values.get(j) != -1){
                return values.get(j);
            }
        }            
       return -1;
    }
}

