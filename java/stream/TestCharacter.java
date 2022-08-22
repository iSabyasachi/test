package test.java.stream;
import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class TestCharacter{
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("Hello","World","Everyone");
        //String result = convertListToString(list);
        //System.out.println(result);
        List<Character> list = Arrays.asList('H','E','L','L','O');
        String str = convertCharacterListToString(list);
        System.out.println(str);
    }
    public static String convertCharacterListToString(List<Character> list){
        String str = list.stream().map(ele -> String.valueOf(ele)).collect(Collectors.joining());
        return str;
    }
    public static String convertListToString(List<String> list){
        
        //StringBuilder strs = new StringBuilder();
        //list.stream().flatMap(ele -> Stream.of(ele.charAt(0))).forEach(strs::println);

        Character[] chars = list.stream().flatMap(ele -> Stream.of(ele.charAt(0))).toArray(Character[]::new);
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < chars.length ; i++){
            str.append(chars[i]);
        }
        return str.toString();
    }

}