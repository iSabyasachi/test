package test.arrays;
/**
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */
public class RemoveDuplicates{  

    public static void main(String[] args) {
        //int[] arr = new int[]{1,1,2};//Result 2
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};//Result 5
        int length = removeDuplicates(arr);
        System.out.println(length);
    }
    /**
    Time Complexity : O(N)
    Space Complexity : O(1)
    
     */
    public static int removeDuplicates(int[] nums){
        if(nums.length == 1)
            return 1;
        //Non Duplicate
        int nd = 1;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != nums[nd - 1]){
                nums[nd] = nums[i];              
                nd++;
            }
        }
        return nd;
    }
}

