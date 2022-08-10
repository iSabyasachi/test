package test;
import java.util.*;


public class PlusOne{
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        int[] res = plusOne(input);
        System.out.println(Arrays.toString(res));
    }

    public static int[] plusOne(int[] digits) {
        int num = 0;
        int i = 0;
        while(i < digits.length){
            num = num * 10 + digits[i];
            i++;
        }
        num++;
        //124
        int[] result = new int[String.valueOf(num).length()];
        int j = result.length - 1;
        while(j >= 0){
            result[j] = num%10;
            num = num / 10;
            j--;
        }
        return result;
    }
}

