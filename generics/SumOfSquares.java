package test.generics;

import java.util.*;


public class SumOfSquares{  

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Double res = sumOfSquares(list);
        System.out.println(res);

        List<Double> dlist = new ArrayList<>();
        dlist.add(1.0);
        dlist.add(2.0);
        dlist.add(3.0);

        Double dRes = sumOfSquares(dlist);
        System.out.println(dRes);

    }
    public static Double sumOfSquares(List<? extends Number> inputList){        
        Double res = 0.0;
        for(Number num : inputList){
            res += num.doubleValue() * num.doubleValue();
        }
        return res;
    }

    
}

