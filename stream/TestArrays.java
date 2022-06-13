package test.stream;

import java.util.*;
import java.util.stream.*;

public class TestArrays{
    public static void main(String[] args){
        /**
        //Ex 1. Convert an int array to Integer Array
        int[] inputArr = new int[]{1, 2, 3, 4};
        Integer[] resultArr = convertIntArrayToIntegerArray(inputArr);
        System.out.println(Arrays.toString(resultArr));*/

        /**
        //Ex 2. Add All Elements From Array To List */
        Integer[] inputArr = new Integer[]{1, 2, 3, 4};
        List<Integer> result = addAllElementsFromArrayToList(inputArr);
        System.out.println(result);
    }

    public static Integer[] convertIntArrayToIntegerArray(int[] inputArr){
        return IntStream.of(inputArr).boxed().toArray(Integer[]::new);
    }

    public static List<Integer> addAllElementsFromArrayToList(Integer[] inputArr){
        List<Integer> result = new ArrayList<>();
        Collections.addAll(result, inputArr);
        return result;
    }
}