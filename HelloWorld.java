package test;

import java.util.*;
import java.util.stream.IntStream;
public class HelloWorld{

    public static void main(String[] args){
        System.out.println("Hello World!!!");
        
       int[] arr = new int[]{1,2,3,4,5,6};
       System.out.println(Arrays.toString(arr));
       arr = Arrays.copyOfRange(arr, 2,4);
       System.out.println(Arrays.toString(arr));
    }

}