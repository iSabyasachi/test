package test.generics;

import java.util.*;


public class IntegerPrinter{  
    Integer thingToPrint;

    public IntegerPrinter(Integer thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }
   
}
