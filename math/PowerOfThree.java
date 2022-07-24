package test.math;

import java.util.*;

public class PowerOfThree{  

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(28));        
    }
    public static boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        else if(n == 1) return true;        
             
        return isPowerOfThree(n/3);
    }
    public static boolean isPowerOfThreeOpt(int n) {
        if(n < 0) return false;        
        while(n % 3 == 0){
            n = n / 3;
        }        
        return n == 1;
    }
}

