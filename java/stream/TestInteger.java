package test.java.stream;

import java.util.*;
import java.util.stream.*;

public class TestInteger{
    
    public static Integer[] convertIntArrayToIntegerArray(int[] inputArr){
        return IntStream.of(inputArr).boxed().toArray(Integer[]::new);
    }

    public static int[] convertIntegerArrayToIntArray(Integer[] inputArr){
        return Arrays.stream(inputArr).mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> convertArrayToList(Integer[] inputArr){
        List<Integer> result = new ArrayList<>();
        Collections.addAll(result, inputArr);
        return result;
    }

    public static int[] convertListToArray(List<Integer> inputList){        
        return inputList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        
        //Ex 1. Convert an int array to Integer Array
        /*int[] inputArr = new int[]{1, 2, 3, 4};
        Integer[] resultArr = convertIntArrayToIntegerArray(inputArr);
        System.out.println(Arrays.toString(resultArr));*/
       
        //Ex 2. Convert an Integer array to int array
        Integer[] inputArr = new Integer[]{5, 6, 7, 8};
        int[] resultArr = convertIntegerArrayToIntArray(inputArr);
        System.out.println(Arrays.toString(resultArr));

        
        //Ex 3. Add All Elements From Array To List */
        /*Integer[] inputArr = new Integer[]{1, 2, 3, 4};
        List<Integer> result = convertArrayToList(inputArr);
        System.out.println(result);*/

        //Ex 4. Convert a List to Int Array
        /*List<Integer> inputList = Arrays.asList(1,2,3,4);
        System.out.println(Arrays.toString(convertListToArray(inputList)));*/

    }
    
}