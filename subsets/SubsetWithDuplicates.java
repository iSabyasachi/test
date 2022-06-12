package test.subsets;

import java.util.*;
/**
Given a set of numbers that might contain duplicates, find all of its distinct subsets.
Example 1:
Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]

Example 2:
Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3] 

Time Complexity : O(N 2^N)
Space Complexity : O(N 2^N)

 */
class SubsetWithDuplicates {
  public static List<List<Integer>> findSubsets(int[] nums) {    
    Arrays.sort(nums);

    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    
    int startIndex = 0, endIndex = 0;

    for(int i = 0 ; i < nums.length ; i++){
      if(i > 0 && nums[i] == nums[i - 1])
        startIndex = endIndex + 1;
      
      endIndex = subsets.size() - 1;
    
      for(int j = startIndex ; j <= endIndex ; j++){
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]);
        subsets.add(set);
      }
    }

    return subsets;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 5 });
    System.out.println("Here is the list of subsets: " + result);

    /*
    result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);*/
  }
}