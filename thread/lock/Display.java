package test.thread.lock;
import java.util.concurrent.locks.*;
public class Display{
    ReentrantLock l = new ReentrantLock();
    public void wish(String name){
        l.lock();
        for(int i = 0 ; i < 10 ; i++){
            System.out.println("Good Morning: ");
            try{
                Thread.sleep(1000);

            }catch(InterruptedException ie){

            }
            System.out.println(name);
        }
        l.unlock();
    }
}