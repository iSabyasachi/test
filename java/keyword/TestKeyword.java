package test.java.keyword;
import java.util.*;


public class TestKeyword{
    public static void main(String[] args) {
       Animal animal = new Dog("German Sheffard");
       animal.whoAmI();
       DomesticAnimal domesticAnimal = (DomesticAnimal)animal;
       domesticAnimal.groom();
       domesticAnimal.recognizePeople();
        System.out.println("---");
       animal = new Cat("Meuw Cat");
       animal.whoAmI();
       domesticAnimal = (DomesticAnimal)animal;
       domesticAnimal.eat();
       domesticAnimal.groom();
       domesticAnimal.recognizePeople();
    }
}

