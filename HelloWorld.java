package test;

import java.util.*;


public class HelloWorld{  

    public static void main(String[] args) {
       String[] input = new String[]{"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(input, chars));
    }
    public static int[] createTable(String chars){
        int[] table = new int[128];
        for(char ch : chars.toCharArray()){
            table[ch]++;
        }  
        return table;
    }
    public static int countCharacters(String[] words, String chars) {
        int sumOfLengths = 0;
        //Store the chars in int table               
        //check if the character of each word is present in table, if yes, add the length to the table
        for(String word : words){
            int[] currTable = createTable(chars);
            System.out.println(Arrays.toString(currTable));
            boolean isPresent = true;
            for(char ch : word.toCharArray()){
                currTable[ch]--;
                if(currTable[ch] == -1){
                    isPresent = false;                    
                }
            }
            if(isPresent)
                sumOfLengths += word.length();
        }
        return sumOfLengths;
        
    }
   
}

