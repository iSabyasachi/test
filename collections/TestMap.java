package test.collections;
import java.util.*;
import java.util.stream.*;

public class TestMap{
    public static void main(String[] args){
        int[] nums = new int[] { 1, 3, 5, 12, 11, 12, 11 };
        
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int num : nums){
            if(numMap.containsKey(num)){
                numMap.put(num, numMap.get(num) + 1);
            }else{
                numMap.put(num, 1);
            }
        }        
        System.out.println(numMap);
        //sortValues(numMap);

        numMap = numMap.entrySet().stream()
        .sorted((c1, c2) -> c2.getValue()
        .compareTo(c1.getValue()))
        .collect(Collectors.toMap(Map.Entry::getKey,
                                    Map.Entry::getValue, (e1, e2)-> e1, LinkedHashMap::new));
        System.out.println(numMap);
    }

    private static void sortValues(Map<Integer, Integer> map){
        List entryList = new LinkedList<>(map.entrySet());
        Comparator<Map.Entry> valueComparator = new Comparator(){
            public int compare(Object o1, Object o2){
                return ((Comparable)((Map.Entry)o2).getValue()).compareTo(((Map.Entry)o1).getValue());
            }
        };
        Collections.sort(entryList, valueComparator);
        System.out.println(entryList);
    }
}