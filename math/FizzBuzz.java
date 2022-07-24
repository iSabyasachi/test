package test.math;

import java.util.*;
/**
Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.

Input: n = 3
Output: ["1","2","Fizz"]
 */
public class FizzBuzz{  

    public static void main(String[] args) {
       List<String> result = fizzBuzz(5);
       System.out.println(result);
    }
    
   public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        int i = 1;
        while(i <= n){
            if(i % 3 == 0 && i % 5 == 0){
                result.add("FizzBuzz");
            }else if(i % 3 == 0){
                result.add("Fizz");
            }else if(i % 5 == 0){
                result.add("Buzz");
            }else{
                result.add(String.valueOf(i));
            }
            i++;
        }
        return result;
    }
}

