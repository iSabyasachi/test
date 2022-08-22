package test.subsets;
import java.util.*;
import java.util.stream.*;
/**
Time Complexity : Permutation : N! * (Insert a number into a permutation of size N is N ), so total O(N! * N)
Space Complexity : O(N! * N)
 */
class PermutationsBackTracking {
    /**
    Algorithm :
    for(i = left ; i < right ; i++){
        swap(str, left  , i);
        permute(str, i + 1, right);
        swap(str, left , i);
    }
     */
    
    public static void main(String[] args) {  
        PermutationsBackTracking obj = new PermutationsBackTracking();      
        List<List<Integer>> result = obj.permute(new int[] { 1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for(int num : nums){
            input.add(num);
        }
        backTrack(0 , nums.length , input , output);
        return output;
    }

    public void backTrack(int start, int end, List<Integer> input, List<List<Integer>> output){        
        if(start == end)
            output.add(new ArrayList<Integer>(input));
        
        for(int i = start ; i < end  ; i++){           
            Collections.swap(input, start, i);
            backTrack(start + 1 , end , input , output);
            Collections.swap(input, start, i);
        }
    }
}