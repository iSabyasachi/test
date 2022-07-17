package test.arrays;

import java.util.*;

public class RotateArray{  

    public static void main(String[] args) {
        //int[] nums = new int[]{1,2,3,4,5,6,7};
        //int[] nums = new int[]{-1,-100,3,99};
         int[] nums = new int[]{1,2};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
     */
    public static void rotate(int[] nums, int k) { 
        k %= nums.length;      
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
    public static void rotateUsingMemory(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        while(i < nums.length){
            queue.add(nums[i]);
            i++;
        }
        //System.out.println(queue);
        while(k > 0){
            int temp = queue.removeLast();
            queue.addFirst(temp);
            k--;
        }
        int j = 0;
        while(!queue.isEmpty()){
            nums[j++] = queue.poll();
        }
        //System.out.println(queue);
    }
    
    
}

