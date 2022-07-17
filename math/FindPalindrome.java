package test.math;

public class FindPalindrome{
    public static void main(String[] args){
        int num = 121;
        System.out.println("Is Palindrome? "+isPalindrome(num));
    }

    public static boolean isPalindrome(int num){
        System.out.println("num"+num);
        int rev = 0;
        int curr = num;
        while(curr > 0){
            int lastDigit = curr % 10;
            rev = (rev * 10) + lastDigit;
             System.out.println("rev"+rev);
            curr = curr / 10;
        }
        
       
        if(num == rev){
            return true;
        }else{
            return false;
        }
    }
}