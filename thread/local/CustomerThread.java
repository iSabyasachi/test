package test.thread.local;

public class CustomerThread extends Thread{
    static Integer custId = 0;
    private static ThreadLocal tl = new ThreadLocal(){
        protected Integer initialValue(){
            return ++custId;
        }
    };
    public CustomerThread(String name){
        super(name);
    }   

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" Executing with customer id: "+tl.get());
    }
}