package test.arrays;
import java.util.Arrays;
public class PermutationString{
    public static void main(String[] args){
        String first = "abcd";
        String second = "cdbaa";
        boolean result = isPermutation(first, second);
        System.out.println(result);
    }
    public static boolean isPermutation(String first, String second){
        int[] table = new int[128];
        for(int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);
            table[ch]++;
        }
        System.out.println(Arrays.toString(table));

        for(int j = 0; j < second.length(); j++){
            char ch = second.charAt(j);            
            table[ch]--;            
        }
        for(int k = 0; k < table.length; k++){
            if(table[k] != 0){
                return false;
            }
        }
        return true;
    }

}