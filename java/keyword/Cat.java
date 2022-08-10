package test.java.keyword;
import java.util.*;


public class Cat extends DomesticAnimal{
    String name;
    public Cat(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println("Cat is eating!!!");
    }

    public void whoAmI(){
        System.out.println("I am "+name);
    };

    public final void groom(){
        System.out.println(name+" needs grooming!!!");
    };
}

