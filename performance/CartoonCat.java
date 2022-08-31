package test.performance;

import java.util.*;
import java.util.concurrent.*;
/**How many times does the following application print Ready at runtime? */

public class CartoonCat{
    public void march(CyclicBarrier c) {
      ExecutorService s = Executors.newSingleThreadExecutor();
      for(int i=0; i<12; i++)
         s.execute(() -> await(c));
      s.shutdown();
    }
    public static void main(String[] args){
        new CartoonCat().march(new CyclicBarrier(4,
            () -> System.out.println("Ready")));
    }

}