package test.java.collections;
import java.util.*;

public class LRUCache<K, V> extends LinkedHashMap<K, V>
{   
    private int maxSize;
    public LRUCache(int maxSize){
        super(maxSize, 075f, true);
        this.maxSize = maxSize;
    }

    public boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > maxSize;
    }
    
    public static void main(String[] args){
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(1, 5);
        System.out.println(cache);
        System.out.println(cache.get(2));
        /*cache.set(3, 4);
        cache.set(2, 4);
        cache.set(4, 5);
        System.out.println(cache);*/
        //System.out.println(cache.get(2));
    }
}