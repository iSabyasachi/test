package test.sort;
import java.util.*;

public class TopKFrequent{
    public static void main(String[] args){
        int[] nums = {3,0,1,0}; int k = 1;
        int[] res = topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        Queue<Integer> heap = new PriorityQueue<>((key1, key2) -> map.get(key1) - map.get(key2));
        for(Integer key : map.keySet()){
            heap.add(key);
            if(heap.size() > k) heap.poll();
        }
        
        for(int i = 0 ; i < k ; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}