package test.stream;

import java.util.*;
import java.util.stream.*;

public class TestDouble{

    public static Double[] convertdoubleArrayToDoubleArray(double[] inputArr){
        return DoubleStream.of(inputArr).boxed().toArray(Double[]::new);
    }

    public static double[] convertDoubleArrayTodoubleArray(Double[] inputArr){
        return Arrays.stream(inputArr).mapToDouble(Double::doubleValue).toArray();
    }

    public static List<Double> convertArrayToList(Double[] inputArr){
        List<Double> result = new ArrayList<>();
        Collections.addAll(result, inputArr);
        return result;
    }

    public static double[] convertListToArray(List<Double> inputList){        
        return inputList.stream().mapToDouble(i -> i).toArray();
    }
    
    public static void main(String[] args){
        
        //Ex 1. Convert an double array to Double Array
        /*double[] inputArr = new double[]{1.1, 2.1, 3.1, 4.1};
        Double[] resultArr = convertdoubleArrayToDoubleArray(inputArr);
        System.out.println(Arrays.toString(resultArr));*/
       
        //Ex 2. Convert an Integer array to int array
        /*Double[] inputArr = new Double[]{5.1, 6.1, 7.1, 8.1};
        double[] resultArr = convertDoubleArrayTodoubleArray(inputArr);
        System.out.println(Arrays.toString(resultArr));*/

        
        //Ex 3. Add All Elements From Array To List */
        /*Double[] inputArr = new Double[]{1.1, 2.1, 3.1, 4.1};
        List<Double> result = convertArrayToList(inputArr);
        System.out.println(result);*/

        //Ex 4. Convert a List to Double Array
        List<Double> inputList = Arrays.asList(1.1,2.2,3.1,4.1);
        double[] result = convertListToArray(inputList);
        System.out.println(Arrays.toString(result));

    }
}