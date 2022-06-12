package test.heap;
import java.util.*;
import java.util.stream.Collectors;
/**
Given a string, sort it based on the decreasing frequency of its characters.

Ex 1: Input: "Programming"
Output: "rrggmmPiano"
Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.

Ex2 :
Input: "abcbab"
Output: "bbbaac"
Explanation: 'b' appeared three times, 'a' appeared twice, and 'c' appeared only once.


Time Complexity : O(N Log N)
Space Complexity : O(N)
 */

 class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    char[] chars = str.toCharArray();
    for(char ch : chars){
        frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }
    System.out.println(frequencyMap);
    
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
    /*
    for(Map.Entry<Character, Integer> me : frequencyMap.entrySet()){
        maxHeap.add(me);
    }*/
    maxHeap.addAll(frequencyMap.entrySet());   
    StringBuilder result = new StringBuilder();
    while(!maxHeap.isEmpty()){
        Map.Entry<Character, Integer> me = maxHeap.poll();
        for(int i = 0 ; i < me.getValue() ; i++){
            result = result.append((Character)me.getKey());
        }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
    /*
    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);*/
  }
}