package test.math;
import java.util.*;
public class FindFibonacci{
    public static void main(String[] args){
        int num = 6;
        /*for(int i = 0; i < num ; i++){
            System.out.println(fib(i));
        }*/
        //fibUsingHashMap(6);   
        fibWOUsingHashMap(6);  
    }
    public static void fibWOUsingHashMap(int num){
        int first = 0, second = 0, result = 0;

        int i = 0;
        while(i <= num){
            if(i == 0){
                first = 0;
                result = 0;
            }else if(i == 1){
                second = 1;
                result = 1;
            }else{
                result = first + second;
                first = second;
                second = result;
            }
            System.out.println(result);
            i++;
        }
    }
    public static void fibUsingHashMap(int num){
        Map<Integer, Integer> hm = new HashMap<>();
        int res = 0;
        int i = 0;
        while(i <= num){                   
            if(i == 0){
               res = 0;                
            }else if(i == 1){                
                res = 1;                
            }else{
                res = hm.get(i - 2) + hm.get(i - 1);
            }
            hm.put(i, res);             
            i++;
            System.out.println(res);
        }
    }
    public static int fib(int num){
        if(num == 0){
            return 0;
        }else if(num == 1){
            return 1;
        }else{
            return fib(num - 2) + fib(num - 1);
        }

    }

}