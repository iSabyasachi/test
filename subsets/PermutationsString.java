package test.subsets;
import java.util.*;
import java.util.stream.*;

public class PermutationsString{
    public static void main(String[] args){
        PermutationsString obj = new PermutationsString();
        String input= "abc";
        List<String> result = obj.permutations(input);
        System.out.println(result);
    }

    public List<String> permutations(String str){
        List<Character> input = new ArrayList();
        List<List<Character>> output = new ArrayList<>();
        
        for(int i = 0 ; i < str.length() ; i++){
            input.add(str.charAt(i));
        }

        backtrack(0, str.length(), input, output);
        List<String> result = new ArrayList<>();
        for(List<Character> chars : output){            
            result.add(chars.stream().map(String::valueOf).collect(Collectors.joining()));
        }
        return result;
    }

    public void backtrack(int start, int end, List<Character> input, List<List<Character>> output){
        if(start == end)
            output.add(new ArrayList<Character>(input)); 

        for(int i = start ; i < end ; i++){
            Collections.swap(input, start, i);
            backtrack(start + 1, end, input, output);
            Collections.swap(input, start, i);
        }
    }
}