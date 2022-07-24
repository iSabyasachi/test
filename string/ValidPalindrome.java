package test.string;

import java.util.*;

public class ValidPalindrome{  

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        //String s = "amanaplanacanalpanama";
        //String s = "0P";
        System.out.println(isPalindrome(s));
    }
    /*
    Time Complexity : 
    Space Complexity : 
    */
    public static boolean isPalindrome(String s){       
        for(int i = 0, j = s.length()-1; i < j ;i++,j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
    /*
    Time Complexity : O(N)
    Space Complexity : O(N)
    */
    public static boolean isPalindromeOpt(String s){          
        StringBuilder sb = new StringBuilder(s.length());
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)){
                sb.append(Character.toLowerCase(ch));
            }else if(Character.isDigit(ch)){
                sb.append(ch);
            }
        }        
        s = sb.toString();
        int low = 0, high = s.length()-1;
        while(low <= high){            
            if(s.charAt(low) != s.charAt(high))
                return false;            
            low++;
            high--;
        }
        return true;
    }
}

