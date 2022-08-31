package test.performance;
import java.util.concurrent.atomic.*;
import java.util.stream.*;

public class TicketTaker{
    long ticketSold;
    final AtomicInteger ticketsTaken;

    public TicketTaker(){
        ticketSold = 0;
        ticketsTaken = new AtomicInteger();
    }
    public static void main(String[] args){
        TicketTaker obj = new TicketTaker();
        obj.performJob();
    }
    public void performJob(){
        IntStream.iterate(1, p->p+1)
        .parallel()
        .limit(10)
        .forEach(i-> 
        ticketsTaken.getAndIncrement());

        IntStream.iterate(1, q-> q+1)
        .limit(5)
        .parallel()
        .forEach(i->++ticketSold);

        System.out.println(ticketsTaken+" "+ticketSold);
    }

}