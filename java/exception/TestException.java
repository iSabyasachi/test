package test.java.exception;
import java.util.*;

public class TestException{
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
            System.out.println(a/b);
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
            //System.exit(0);
        }finally{
            System.out.println("Inside Finally");
        }
        System.out.println("After exception handler");

        int[] arr = new int[4];
        arr[4] = 0;
        System.out.println("After array index bound exception");
    }
    
}

