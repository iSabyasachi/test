package test.java.stream;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class TopQuestions{

    public static void main(String[] args) {
        //allEvenNums();
        startingWithOne();
        //sumOfIntegers();
        //findDuplicate();
        //findFirstElement();
        //findMaxValue();
        //sortAnArray();
        //reverseSortAnArray();
        //findFirstNonrepeated();
        //findFirstRepeated();

    }

    public static void allEvenNums(){
        /**
        Q1 Given a list of integers, find out all the even numbers exist in the list using Stream functions?
         */

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void startingWithOne(){
        /**
        Q2 Given a list of integers, find out all the numbers starting with 1 using Stream functions?
         */
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        myList.stream()
                .map(s -> s+"")
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println); 

    }

    public static void findDuplicate(){
        /*Q3 How to find duplicate elements in a given integers list in java using Stream functions?*/
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();
        myList.stream().filter(ele -> !set.add(ele)).forEach(System.out::println);
    }
    
    public static void findFirstElement(){
        /*Q4 Given the list of integers, find the first element of the list using Stream functions?*/
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().findFirst().ifPresent(System.out::println);
    }
    

    public static void sumOfIntegers(){
        /**
        Q5 Given a list of integers, find the total number of elements present in the list using 
            Stream functions?
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        int sum = list.stream().mapToInt(ele -> ele).sum();
        System.out.println(sum);

        long count = list.stream().count();
        System.out.println(count);
    }

    public static void findMaxValue(){
        /**
        Q6 Given a list of integers, find the maximum value element present in it using Stream functions?
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        int max = list.stream().reduce((x, y) -> x > y ? x : y).get(); 
        System.out.println(max);

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int maxVal = myList.stream()
                        .max(Integer::compare)
                        .get();
        System.out.println(maxVal);
    }
    
    public static void findFirstNonrepeated(){
        /**
        Q7 Given a String, find the first non-repeated character in it using Stream functions?
         */
        String input = "Java Hungry Blog Alive is Awesome";
        Character result = input.chars() // Stream of String       
                                    .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                    .entrySet()
                                    .stream()
                                    .filter(entry -> entry.getValue() == 1L)
                                    .map(entry -> entry.getKey())
                                    .findFirst()
                                    .get();
            System.out.println(result);  
        
    }
    public static void findFirstRepeated(){
        /** Q8 Given a String, find the first repeated character in it using Stream functions? */
        String input = "Java Hungry Blog Alive is Awesome";
        Character result = input.chars()
                                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))  
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() > 1L)
                                .map(entry -> entry.getKey())
                                .findFirst()
                                .get();
        System.out.println(result); 
    }           
   

    public static void sortAnArray(){
        /**Q9 Given a list of integers, sort all the values present in it using Stream functions? */
        List<Integer> list = Arrays.asList(11,6,3,4,15,16);
        list = list.stream().sorted().collect(Collectors.toList());
        //list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void reverseSortAnArray(){
        /**Q10 Given a list of integers, sort all the values present in it in descending order using Stream functions? */
        List<Integer> list = Arrays.asList(11,6,3,4,15,16);        
        list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list);
    }

    
    
}
/**






















 */