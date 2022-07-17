package test.arrays;
import java.util.Arrays;
import java.util.*;
public class StringCompression{
    public static void main(String[] args){
        String input = "aabcccccdde";        
        String result = compressString(input);
        System.out.println(result);
    }
    public static String compressString(String input){
        StringBuilder compressed = new StringBuilder(); 
        int count = 0;       
        for(int i = 0; i < input.length() ; i++){ 
            count++;                      
            if(i+1 >= input.length() || input.charAt(i) != input.charAt(i+1)){
                compressed.append(input.charAt(i));
                compressed.append(count);
                count = 0;             
            }
        }        
        
        return compressed.toString();
    }
    
    public static String compressStringOpt(String input){        
        int windowStart = 0, windowEnd = 0;
        StringBuilder output = new StringBuilder();        
        for(windowEnd = 0; windowEnd < input.length() ; windowEnd++){                       
            if(input.charAt(windowEnd) != input.charAt(windowStart)){
                output.append(input.charAt(windowStart));
                output.append(input.substring(windowStart, windowEnd).length());
                windowStart = windowEnd;                
            }
        }        
        output.append(input.charAt(windowStart));
        output.append(input.substring(windowStart, windowEnd).length());
        return output.toString();
    }

}