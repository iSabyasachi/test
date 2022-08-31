package test.math;
import java.util.stream.*;
public class FindPrimeNumber{
    public static void main(String[] args){
        int num = 13;
       // System.out.println("Is Prime Number? "+isPrimeNumber(num));
        System.out.println("Is Prime Number? "+isPrimeNumberUsingStream(num));
    }

    public static boolean isPrimeNumber(int num){
        for(int i = 2; i < Math.sqrt(num) ; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrimeNumberUsingStream(int num){
        return num > 1 
                && IntStream.rangeClosed(2, (int)Math.sqrt(num)).noneMatch(divisor -> num % divisor == 0);
        
    }
}