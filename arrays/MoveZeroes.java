package test.arrays;
import java.util.*;


public class MoveZeroes{
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void moveZeroes(int[] nums) {
        if(nums.length == 1)
            return nums;
        //Find next Zero Number and replace with Non Zero Number
        int nz = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                int temp = nums[nz];
                nums[nz] = nums[i];
                nums[i] = temp;
                nz++;
            }
        }
        
    }
}

