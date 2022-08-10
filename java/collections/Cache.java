package test.java.collections;
import java.util.*;
import java.sql.Timestamp;
import java.time.Instant;

public class Cache{
    private static final int MAX = 3;

    public static void main(String[] args){
        Student s1 = new Student(1, "Sabyasachi");
        Student s2 = new Student(2, "Pragyan");
        Student s3 = new Student(3, "Aariketh");      
        Student s4 = new Student(4, "Soumya");
        LinkedHashMap<Integer, Student> cacheList = new LinkedHashMap<Integer, Student>(){
            protected boolean removeEldestEntry(Map.Entry<Integer, Student> eldestEntry){
                return size() > MAX;
            }
        };
        addToCache(cacheList, s1);
        addToCache(cacheList, s2);
        addToCache(cacheList, s3);
        addToCache(cacheList, s4);

        for(Map.Entry<Integer, Student> me : cacheList.entrySet()){
            System.out.println(me.getValue());
        }

        System.out.println("---");

        Student s = findStudent(cacheList, 2);
        System.out.println(s != null ? s.name : "NA");
    }
    public static void addToCache(LinkedHashMap<Integer, Student> cacheList, Student std){    
        cacheList.put(std.rollNo, std);    
    }

    public static Student findStudent(LinkedHashMap<Integer, Student> cacheList, int rollNo){
        if(cacheList.containsKey(rollNo)){
            return cacheList.get(rollNo);
        }
        return null;
    }
}

class Student{
    int rollNo;
    String name;
    Timestamp createdDateTs;

    public Student(int rollNo, String name){
        this.rollNo = rollNo;
        this.name = name;
        this.createdDateTs =  Timestamp.from(Instant.now());
    }

    public String toString(){
        return name +" "+createdDateTs;
    }
}
