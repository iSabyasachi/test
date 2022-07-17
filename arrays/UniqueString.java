package test.arrays;
import java.util.Arrays;
public class UniqueString{
    public static void main(String[] args){
        String input = "abcde";
        boolean result = isUnique(input);
        System.out.println(result);
    }
    public static boolean isUnique(String input){
        int[] table = new int[128];
        for(char ch : input.toCharArray()){           
            table[ch] = table[ch] + 1;
            if(table[ch] > 1){
                return false;
            }
        }
        //System.out.println(Arrays.toString(table));
        return true;
    }
}