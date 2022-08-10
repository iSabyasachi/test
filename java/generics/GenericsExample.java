package test.java.generics;

import java.util.*;


public class GenericsExample{  

    public static void main(String[] args) {
        Printer<String> sPrinter = new Printer<>("Sabya");
        sPrinter.print();

        Printer<Integer> iPrinter = new Printer<>(10);
        iPrinter.print();

        Printer<Double> dPrinter = new Printer<>(10.0);
        dPrinter.print();

        /*IntegerPrinter iPrinter = new IntegerPrinter(23);
        iPrinter.print();
        */   

        shout(1);
        shout("Hey");
        shout("Hello","World");

        AdvancePrinter<String, Double> advPrinter = new AdvancePrinter<>("Sabyasachi",1.0);
        advPrinter.print();

        String res = showShout("Just","Another Day");
        System.out.println(res);

    }
    public static <T> void shout(T thingToShout){
        System.out.println(thingToShout +"!!!!");
    }

    public static <T, V> void shout(T thingToShout, V otherThingToShout){
        System.out.println(thingToShout +" " +otherThingToShout);
    }

    public static <T, V> T showShout(T thingToShout, V otherThingToShout){
        return thingToShout;
    }
    
   
}

