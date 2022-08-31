package test.thread.lock;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class MyThread extends Thread{
    static ReentrantLock l = new ReentrantLock();
    Display d;
    String name;
    //Test TryLock
    public MyThread(String name){
        //this.name = name;
        super(name);
    }

    public MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    /*
    @Override
    public void run(){
        d.wish(name);
    }*/
    /*
    @Override
    public void run(){
        if(l.tryLock()){
            System.out.println(Thread.currentThread().getName()+" got lock and performing operations.");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException ie){
            }
            l.unlock();
        }else{
            System.out.println(Thread.currentThread().getName()+" unable to get lock and performing operations.");
        }
    }
    */
    @Override
    public void run(){
        do{
            try{
                if(l.tryLock(500, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName()+" got lock.");
                    Thread.sleep(2000);
                    l.unlock();
                    System.out.println(Thread.currentThread().getName()+"...releases lock.");
                    break;                    
                }else{
                    System.out.println(Thread.currentThread().getName()+"... unable to get lock.Let's try again");                    
                }
            }catch(InterruptedException ie){                
            }
        }while(true);
    }
}