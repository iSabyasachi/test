package test.math;

public class FindPrimeNumber{
    public static void main(String[] args){
        int num = 13;
        System.out.println("Is Prime Number? "+isPrimeNumber(num));
    }

    public static boolean isPrimeNumber(int num){
        for(int i = 2; i < Math.sqrt(num) ; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}