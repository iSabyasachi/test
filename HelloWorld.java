package test;

import java.util.*;
import java.util.stream.*;

public class HelloWorld{  

    public static void main(String[] args) {        
        System.out.println(3 % 4);
    }
    public static boolean isHappyMatric(int[] inputArr, int totalSum, int sum, int i){ 
        if(sum == i + 1 && sum == (totalSum - sum)){
            return true;
        }
        return false;
    }
}
