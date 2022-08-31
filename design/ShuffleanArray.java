package test.design;
import java.util.*;
import java.util.stream.*;

public class ShuffleanArray{
    int[] nums;   
    int[] numsCopy;  
    List<Integer[]> permutations = new ArrayList<>();
    Random rand = new Random();

    public static void main(String[] args){
        
        ShuffleanArray obj = new ShuffleanArray(new int[]{1,2,3,4,5,6,7,8,9});          
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle())); 
    }

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.numsCopy = nums.clone();
    }
    public List<Integer> getList(int[] nums){
        List<Integer> numsList = new ArrayList<>();
        for(int num : nums){
            numsList.add(num);
        }
        return numsList;
    }
    public void swapAt(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int randRange(int min, int max){        
        return rand.nextInt(max - min) + min;
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public int[] shuffle() {
        for(int i = 0 ; i < numsCopy.length; i++){
            swapAt(numsCopy, i, randRange(i, numsCopy.length));
        }
        return numsCopy;
    }
    /**
    Time Complexity O(N^2)
    Space Complexity O(N)
     */
    public int[] shuffleOld() {
        List<Integer> numsList = getList(nums);

        for(int i = 0 ; i < numsCopy.length ; i++){
            int removeNum = rand.nextInt(numsList.size());
            numsCopy[i] = numsList.get(removeNum);
            numsList.remove(removeNum);
        }
        return numsCopy;
    }
    public int[] reset() {
        return nums;
    }
    /*
    Time Complexity ; O(N!)
    public int[] shuffleOld() {
        List<Integer> input = new ArrayList<>();
        for(int num : nums){
            input.add(num);
        }
        //Integer[] inputArr = IntStream.of(nums).boxed().toArray(Integer[]::new);        
        //Collections.addAll(input, inputArr);
        Collections.shuffle(input);
        int[] shuffle = input.stream().mapToInt(Integer::intValue).toArray();      
        return shuffle;
    }*/
    
}