package test.design;
import java.util.*;

public class MinStack {
    int val;
    MinStack next;
    MinStack top;   
    PriorityQueue<Integer> minHeap;

    public MinStack() {
       minHeap = new PriorityQueue<>((e1,e2) -> e1 - e2);
    }
    public MinStack(int val) {
        this.val = val;
    }
    
    public void push(int val) {
        MinStack curr = new MinStack(val);
        minHeap.add(val);
                
        if(top != null){
            curr.next = top;
        }
        top = curr;
    }
    
    public void pop() {
        int currVal = top.val; 
        top = top != null ? top.next : null;
        if(minHeap.peek() == currVal)
            minHeap.poll();
    }
    
    public int top() {
        return top != null ? top.val : -1;
    }
    
    public int getMin() {
        return minHeap.peek();
    }
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println("Min "+minStack.getMin()); // return -3
        System.out.println("Top Ele "+minStack.top());    // return 0
        minStack.pop();        
        System.out.println("Min "+minStack.getMin()); // return -2
    }
}