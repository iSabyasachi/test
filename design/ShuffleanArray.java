package test.design;
import java.util.*;
import java.util.stream.*;

public class ShuffleanArray{
    int[] nums;    
    List<Integer[]> permutations = new ArrayList<>();
    

    public static void main(String[] args){
        
        ShuffleanArray obj = new ShuffleanArray(new int[]{1,2,3,4,5,6,7,8,9,10});          
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));        
    }

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
    }
    public int[] shuffle() {
        List<Integer> input = new ArrayList<>();
        for(int num : nums){
            input.add(num);
        }        
        Collections.shuffle(input);
        int[] shuffle = input.stream().mapToInt(Integer::intValue).toArray();      
        return shuffle;
    }
    public int[] reset() {
        return nums;
    }    
    public void permutations(List<Integer> input, int start, int end, List<List<Integer>> permutations){
        if(start == end){
            permutations.add(new ArrayList<Integer>(input));
            return;
        }
        for(int i = start ; i < end ; i++){
            Collections.swap(input, i, start);
            permutations(input, start+1, end, permutations);
            Collections.swap(input, i, start);
        }
    }
}