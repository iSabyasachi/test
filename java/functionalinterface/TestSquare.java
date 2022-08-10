package test.java.functionalinterface;
import java.util.*;

@FunctionalInterface
interface Square{
    int calculate(int x);
}


public class TestSquare{    
    public static void main(String[] args){
        int a = 5;

        /*
        Square sq = new Square(){
            public int calculate(int x){
                return x * x;
            }
        };
        */
        Square sq = x -> x * x;

        int s = sq.calculate(a);
        System.out.println(s);
    }
   

    
}