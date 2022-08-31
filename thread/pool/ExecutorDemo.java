package test.thread.pool;
import java.util.concurrent.*;
public class ExecutorDemo{
    public static void main(String[] args){
        PrintJob[] jobs = {
            new PrintJob("Job1"),
            new PrintJob("Job2"),
            new PrintJob("Job3"),
            new PrintJob("Job4"),
            new PrintJob("Job5"),
            new PrintJob("Job6"),
        };
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(PrintJob job : jobs){
            service.submit(job);
        } 
        System.out.println("Shutting Down!");
        service.shutdown();
    }
}