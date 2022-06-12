package test.subsets;

import java.util.*;
/**
Time complexity#
Since we can have 2^N permutations at the most and while processing each permutation we convert it into a character array, 
the overall time complexity of the algorithm will be O(N*2^N)

Space Complexity :
All the additional space used by our algorithm is for the output list. Since we can have a total of O(2^N)
permutations, the space complexity of our algorithm is O(N*2^N)
 */
class LetterCaseStringPermutation {

  public static List<String> findLetterCaseStringPermutations(String str) {
    List<String> permutations = new ArrayList<>();
    if(str == null)
      return permutations;
    
    permutations.add(str);
    for(int i = 0 ; i < str.length() ; i++){
        if(Character.isLetter(str.charAt(i))){           
            int n = permutations.size();
            for(int j = 0 ; j < n ; j++){
              char[] chars = permutations.get(j).toCharArray();              
              if(Character.isUpperCase(chars[i])){
                chars[i] = Character.toLowerCase(chars[i]);   
              }else{
                chars[i] = Character.toUpperCase(chars[i]);   
              }
              permutations.add(String.valueOf(chars));
            }
        }
    }
    return permutations;
  }

  public static void main(String[] args) {
    List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
    System.out.println(" String permutations are: " + result);

    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
    System.out.println(" String permutations are: " + result);
  }
}