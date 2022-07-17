package test.arrays;
import java.util.Arrays;
public class PalindromePermutation{
    public static void main(String[] args){
        String input = "Tact Coa";       
        boolean result = isPalindromePermutation(input);
        System.out.println(result);
    }
    public static boolean isPalindromePermutation(String input){ 
        input = input.toLowerCase();       
        int[] table = new int[128];
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch != ' '){
                table[ch]++;
            }            
        }
        int threshold = 1;
        System.out.println(Arrays.toString(table));
        for(int j = 0; j < table.length; j++){
            if(table[j] % 2 == 1){
                    threshold--;
            }else if(table[j] % 2 != 0){                
                return false;
            } 
            if(threshold < 0){                
                return false;
            }
                      
        }
        return true;
    }

}