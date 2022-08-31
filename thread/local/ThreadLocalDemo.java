package test.thread.local;

class ThreadLocalDemo {
    public static void main(String[] args){
        CustomerThread c1 = new CustomerThread("Customer Thread-1");
        CustomerThread c2 = new CustomerThread("Customer Thread-2");
        CustomerThread c3 = new CustomerThread("Customer Thread-3");
        CustomerThread c4 = new CustomerThread("Customer Thread-4");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
    /*
    public static void main(String[] args){
        ThreadLocal tl = new ThreadLocal(){
            protected Object initialValue(){
                return "abc";
            }
        };

        System.out.println(tl.get());
        tl.set("Sabya");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }
    */
}