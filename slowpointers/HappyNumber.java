package test.slowpointers;

import java.util.*;
public class HappyNumber{

    public static void main(String[] args){
        System.out.println("Hello HappyNumber!!!");
        int num = 23;
        //System.out.println("Squires Number -> "+getSqres(num));
        System.out.println(num+" is Happy Number -> "+isHappyNumber(num));
    }
    /**
    Time Complexity : Total 9 digits, 9^2 * M = N -> M = O( Log N)
    Space Complexity : O(1)
     */
    public static boolean isHappyNumber(int num){
        //slow pointer
        int slow = num;
        //fast pointer
        int fast = num;

        do{
            slow = getSqres(slow);
            fast = getSqres(getSqres(fast));
        }while(slow != fast);

        return slow == 1;
    }
    public static int getSqres(int num){
        int sum = 0;
        while(num > 0){
            int currVal = num % 10;
            sum += currVal * currVal;
            num /= 10;
        }
        return sum;
    }

    /**
    Using Linked Hash Set
     */
    public static boolean isHappyNumberUsingHashSet(int num){

        Set<Integer> nums = new LinkedHashSet<>();
        int sum = 0;
        while(num != 1){
            if(nums.contains(num))
                return false;
            
            nums.add(num);
            num = getSqres(num);
        }
        return true;
    }
}