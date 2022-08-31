package test.java;
import java.util.*;
import java.util.stream.*;

public class HelloJava{
    public static void main(String[] args){
        System.out.println("Hello Java");
        List<Double> doubleList = Arrays.asList(1.1, 1.2, 1.3, 1.4, 1.5);
        double res = squareOfNumbers(doubleList);
        System.out.println("Double List Square "+res);      

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        double res1 = squareOfNumbers(intList);
        System.out.println("Integer List Square "+res1);    

        double res2 = squareOfANumber(1.2);
        System.out.println("Integer Square "+res2);   
    }

    public static double squareOfNumbers(List<? extends Number> numList){
        double val=0.0;
        for(Number num : numList){
            val += num.doubleValue() * num.doubleValue();
        }
        return val;
    }

    public static double squareOfANumber(Number num){
        return num.doubleValue() * num.doubleValue();
    }

}