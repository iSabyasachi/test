package test.thread.communication;
import java.util.*;
public class PC{
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    public void produce() throws InterruptedException{
        int value = 0;
        synchronized(this){
            while(true){
                if(list.size() == capacity){
                    wait();
                }
                System.out.println("Producer produces "+value);
                list.add(value++);                

                notify();

                Thread.sleep(5000);
            }
        }
    }

    public void consume() throws InterruptedException{
        synchronized(this){
            while(true){
                if(list.size() == 0){
                    wait();
                }

                int val = list.removeFirst();
                System.out.println("Consumer consumes "+val);

                notify();

                Thread.sleep(5000);
            }
        }
    }
}