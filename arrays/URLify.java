package test.arrays;
import java.util.Arrays;
public class URLify{
    public static void main(String[] args){
        String input = "Mr John Smith  ";
        //String output = "Mr%20John%20Smith";
        String output = getURLify(input, 13);
        System.out.println(output);
    }

    public static String getURLify(String input, int size){
        char[] table = new char[input.length()];
        for(int i = 0; i < input.length() ; i++){
            table[i] = input.charAt(i);
        }         
        StringBuilder output = new StringBuilder();
        for(int j = 0; j < size ; j++){
            if(table[j] == ' ')
                output.append("%20");                
            else
                output.append(table[j]);
        }
        return output.toString();
    }
}