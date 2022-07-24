package test.generics;

import java.util.*;


public class AdvancePrinter<T, V>{  
    T thingToPrint;
    V otherThingToPrint;

    public AdvancePrinter(T thingToPrint, V otherThingToPrint){
        this.thingToPrint = thingToPrint;
        this.otherThingToPrint = otherThingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint+" "+otherThingToPrint);
    }
   
}

