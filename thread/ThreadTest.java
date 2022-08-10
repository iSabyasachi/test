package test.thread;

class ThreadTest implements Runnable{
    private String name;

    public ThreadTest(String name){
        this.name = name;
    }
    public void run(){
        System.out.println(name+" is running!!!");
        Test t1 = new Test("Test");
        System.out.println(t1.getName());
    }
    public static void main(String[] args){        
        ThreadTest test = new ThreadTest("Thread 1");
        Thread t1 = new Thread(test);
        t1.start();
    }
}

/*
class ThreadTest extends Thread{
    private String name;

    public ThreadTest(String name){
        this.name = name;
    }
    public void run(){
        System.out.println(name+" is running!!!");
    }
    public static void main(String[] args){        
        ThreadTest t1 = new ThreadTest("Thread 1");
        t1.start();

        ThreadTest t2 = new ThreadTest("Thread 2");
        t2.start();
    }
}*/