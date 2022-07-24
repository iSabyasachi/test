package test.math;

import java.util.*;

public class CountPrime{  

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
        //System.out.println(isPrime(4));
    }
    
    public static int countPrimes(int n) {
        int num = 0;
        for(int i = 2; i < n ; i++){
            System.out.println(i +" "+isPrime(i));
            if(isPrime(i))
                num++;
        }
        return num;
    }

    public static boolean isPrime(int n){
        for(int i = 2; i * i <= n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
}

