package test;
import java.util.*;
import java.io.*;

public class HelloWorld{
    
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
       int[] array = new int[]{1,2,2,3,3,3,4,4,4,4};      
       hw.removeDuplicate(array);
       System.out.println(Arrays.toString(array));
    }
    public void removeDuplicate(int[] array){
        int nd = 1;
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] != array[nd-1]){
                array[nd] = array[i];
                nd++;
            }
        }
        System.out.println(nd);
    }

    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

