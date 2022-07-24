package test.arrays;

import java.util.*;

public class StringToInteger{  
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static void main(String[] args) {
        //String s="   -42";
        String s = "-2147483648";
        int result = myAtoi(s);        
        System.out.println(result);        
    }
    public static int myAtoi(String s){
        int sign = 1;
        int res = 0;
        if(s.length() == 0 || s.trim().length() == 0)
            return 0;
                
        int i = 0;
        while(s.charAt(i) == ' ')
            i++;
             
        boolean isNegative = false;        
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
           
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }            
            res = res * 10 + digit;
            i++;
        }
       
        return sign * res;
    }
    public static int myAtoiOld(String s){
        if(s.length() == 0 || s.trim().length() == 0)
            return 0;
        int res = 0;
        int i = 0;
        while(s.charAt(i) == ' ')
            i++;
             
        boolean isNegative = false;        
        if(s.charAt(i) == '-'){
            isNegative = true;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
           
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = Character.getNumericValue(s.charAt(i));
            if(isNegative && (-res < Integer.MIN_VALUE/10 || (-res == Integer.MIN_VALUE/10 && -digit < -8))){
                return Integer.MIN_VALUE;
            }else if(!isNegative && (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && digit > 7))){
                return Integer.MAX_VALUE;
            }            
            res = res * 10 + digit;
            i++;
        }
       
        return isNegative ? -res : res;
    }
    
    
}

