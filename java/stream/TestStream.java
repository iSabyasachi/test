package test.java.stream;
import java.util.*;
import java.util.stream.*;

public class TestStream{
    public static void main(String[] args) {
        //Transform and flattening
        //testFlatMap();

        //intermediate operation
        //testMap();

        //testMapToInt();

        testTypeCast();
    }
    
    public static void testTypeCast(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //Integer[] arr = new Integer[]{1,2,3,4,5};
        //int[] intArray = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        //System.out.println(Arrays.toString(intArray));

        //Convert to int[] array
        //int[] array = list.stream().mapToInt(ele -> ele).toArray();
        //System.out.println(Arrays.toString(array));

        //Convert to Integer[] array
        //int[] array = list.stream().mapToInt(ele -> ele).toArray();
        //Integer[] intArray =  IntStream.of(array).boxed().toArray(Integer[]::new);
        //System.out.println(Arrays.toString(intArray));

        //Integer[] intArray = list.stream().mapToInt(ele->ele).boxed().toArray(Integer[]::new);
        //System.out.println(Arrays.toString(intArray));

        //int[] arr = new int[]{1,2,3,4,5};
        //Integer[] intArr = IntStream.of(arr).boxed().toArray(Integer[]::new);
        //System.out.println(Arrays.toString(intArr));
        //IntStream stream = IntStream.of(arr);
        //Integer[] intArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);        
        //System.out.println(Arrays.toString(intArray));
        //int[] array = stream.toArray();
        //System.out.println(Arrays.toString(array));

        

        Integer[] arr = new Integer[]{1,2,3,4,5};
        int[] intArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(intArr));


    }
    public static void testMapToInt(){
        //List<String> list = Arrays.asList("3", "6", "8", "14", "15");
        //list.stream().mapToInt(ele -> Integer.parseInt(ele)).filter(ele -> ele % 3 == 0).forEach(System.out :: println);

        //List<String> list = Arrays.asList("Geeks", "for", "gfg", "GeeksforGeeks", "GeeksQuiz");
        //IntStream iStream = list.stream().mapToInt(ele -> ele.length());
        //System.out.println(iStream.sum());
        //int[] array = iStream.toArray();
        //System.out.println(Arrays.toString(array));

        //List<Integer> list = Arrays.asList(2,3,1,4,5);
        //int[] arr = list.stream().mapToInt(ele -> ele).sorted().toArray();
        //System.out.println(Arrays.toString(arr));

        //List<Integer> list = Arrays.asList(2,3,1,4,5);
        //int max = list.stream().reduce((x,y)-> x > y ? x : y).get();
        //System.out.println(max);

        //IntStream stream = IntStream.range(2,5);
        //stream.forEach(System.out::println);
        
    }
    public static void testMap(){
        //List<Integer> list = Arrays.asList(1,3,4,5,6);
        //list.stream().map(ele -> ele*3).forEach(System.out::println);   

        List<String> list = Arrays.asList("geeks", "gfg", "g", "e", "e", "k", "s");    
        //list = list.stream().map(ele -> ele.toUpperCase()).collect(Collectors.toList());
        //System.out.println(list);
        
    }
    public static void testFlatMap(){
        //List<String> list = Arrays.asList("5.6", "7.4", "4", "1", "2.3");

        //list.stream().flatMap(ele -> Stream.of(ele)).forEach(System.out::println);

        // Creating a List of Strings
        //List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");
        //list.stream().flatMap(ele -> Stream.of(ele.charAt(2))).forEach(System.out::println);

        //Check if even or odd number
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list.stream().flatMap(ele -> Stream.of(ele % 2 == 0)).forEach(System.out::println);

        //List<Integer> primeNumbers = Arrays.asList(5,7,11,13);
        //List<Integer> oddNumbers = Arrays.asList(1,3,5);
        //List<Integer> evenNumbers = Arrays.asList(2,4,6, 8);

        //List<List<Integer>> listOfListOfInts = Arrays.asList(primeNumbers, oddNumbers, evenNumbers);
        //List<Integer> resultList = listOfListOfInts.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        //System.out.println(resultList);
    }
    
}

