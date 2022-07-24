package test.math;

import java.util.*;

public class RomanToInteger{  

    public static void main(String[] args) {
        String input = "IX";
        System.out.println(romanToInt(input));
    }
    public static int romanToInt(String s) {
        Map<String,Integer> romanMap = new HashMap<>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        romanMap.put("IV",4);
        romanMap.put("IX",9);
        romanMap.put("XL",40);
        romanMap.put("XC",90);
        romanMap.put("CD",400);
        romanMap.put("CM",900);
        int res = 0;        
        Queue<String> queue = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++){
            queue.offer(s.charAt(i)+"");
        }       
        while(!queue.isEmpty()){
            String str = queue.poll(); 
            if(romanMap.containsKey(str + queue.peek())){
                res += romanMap.get(str + queue.peek());
                queue.poll();
            }else{
                res += romanMap.get(str);
            }
        }
        return res;
    }
   
}

