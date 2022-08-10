package test.java.keyword;
import java.util.*;


public abstract class DomesticAnimal extends Animal{    
    public void groom(){
        System.out.println("It needs grooming!!!");
    };

    public final void recognizePeople(){
        System.out.println("It can recognize its master!!!");
    };
}

