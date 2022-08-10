package test.java.keyword;
import java.util.*;


public class Tiger extends Animal{
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
}

