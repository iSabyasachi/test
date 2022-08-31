package test.thread.local;

class ThreadLocalDemo2 {
    public static void main(String[] args){
        ParentThread pt = new ParentThread();
        pt.start();
    }
}