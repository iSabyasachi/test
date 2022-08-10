package test.java.numbers;

import java.util.*;


public class Numbers{  

    public static void main(String[] args) {
       List<Integer> intList = Arrays.asList(1,2,3);
       System.out.println(sumOfNumbers(intList));

       List<Double> doubleList = Arrays.asList(1.0,2.0,3.0);
       System.out.println(sumOfNumbers(doubleList));

       List<Long> longList = Arrays.asList(1L,2L,3L);
       System.out.println(sumOfNumbers(longList));

       List<Float> floatList = Arrays.asList(1.1f,2.1f,3.1f);
       System.out.println(sumOfNumbers(floatList));
    }
    public static Double sumOfNumbers(List<? extends Number> list){
        Double res = 0.0;
        for(Number num : list){
            res += num.doubleValue() * num.doubleValue();
        }
        return res;
    }
   
   
}

