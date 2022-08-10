package test.java.keyword;
import java.util.*;


public class Dog extends DomesticAnimal{
    String name;
    public Dog(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println("Dog is eating!!!");
    }

    public void whoAmI(){
        System.out.println("I am "+name);
    };  
    
    public final void groom(){
        System.out.println(name+" needs grooming!!!");
    };
}

