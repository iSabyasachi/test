package test.thread.lock;
public class ReentrantLockDemo{
    public static void main(String[] args){
        /*Display d = new Display();
        MyThread t1 = new MyThread(d, "Dhoni");
        MyThread t2 = new MyThread(d, "Yuvi");*/

        MyThread t1 = new MyThread("Thread1");
        MyThread t2 = new MyThread("Thread2");

        t1.start();
        t2.start();
    }
}