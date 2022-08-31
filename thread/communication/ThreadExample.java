package test.thread.communication;

public class ThreadExample{
    public static void main(String[] args) throws InterruptedException{
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try{
                    pc.produce();
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
                
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                try{
                    pc.consume();
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }                
            }
        });

        t1.start();
        t2.start();

    }
}