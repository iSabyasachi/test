package test.java.stream;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;
public class Test{
    int i;
    public static void main(String[] args) {
        

        /*
        Arrays.asList(1,2,3,4).stream().forEach(System.out::println);
        Arrays.asList(1,2,3,4).parallelStream().forEachOrdered(System.out::println);
        */
        /*
        List<String> list = Arrays.asList("Hello","World","Everyone");

        StringBuilder strs = new StringBuilder();
        list.stream().flatMap(ele -> Stream.of(ele.charAt(0))).forEach(strs::println);


        Character[] chars = list.stream().flatMap(ele -> Stream.of(ele.charAt(0))).toArray(Character[]::new);
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < chars.length ; i++){
            str.append(chars[i]);
        }
        System.out.print(str);
        */
    }
}
