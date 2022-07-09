package test.subsets;
import java.util.*;
import java.util.stream.*;
/**
Time Complexity : Permutation : N! * (Insert a number into a permutation of size N is N ), so total O(N! * N)
Space Complexity : O(N! * N)
 */
class Permutations {

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();        
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    public static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation, List<List<Integer>> result) {
        if(index == nums.length){            
            result.add(currentPermutation);
        }else{
            // create a new permutation by adding the current number at every position
            for(int i = 0 ; i <= currentPermutation.size() ; i++){
               List<Integer> newPermutation = new ArrayList<>(currentPermutation); 
               newPermutation.add(i, nums[index]);
               //System.out.println(i+"->"+index+" "+newPermutation+" "+result);
               generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for(int num : nums){
            int n = permutations.size();      
            for(int i = 0 ; i < n ; i++){
                List<Integer> oldPermutation = permutations.poll();            
                for(int j = 0 ; j <= oldPermutation.size() ; j++){
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);                
                    newPermutation.add(j, num);
                    if(newPermutation.size() == nums.length){
                        result.add(newPermutation);
                    }else{
                        permutations.add(newPermutation); 
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5});*/
        List<List<Integer>> result = Permutations.generatePermutations(new int[] { 1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }
}