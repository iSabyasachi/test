package test;

import java.util.*;
import java.util.stream.*;

public class HelloWorld{  

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> result = permutation(arr);
        System.out.println(result);
    }
    
    public static List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();        
        permutations.offer(new ArrayList<>());
        for(int num : nums){            
            int N = permutations.size();
            for(int i = 0; i < N; i++){
                List<Integer> oldPermutation = permutations.poll();
                for(int j = 0; j <= oldPermutation.size() ; j++){
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
    
    
}

