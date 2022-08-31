package test.thread.pool;
import java.util.concurrent.*;
public class PrintJob implements Runnable{
    String name;

    public PrintJob(String name){
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println(name +" ...Job started by Thread: "+Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ie){}
        System.out.println(name +" ...Job completed by Thread: "+Thread.currentThread().getName());        
    }

}