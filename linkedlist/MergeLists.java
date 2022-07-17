package test.linkedlist;

import java.util.*;
import java.util.stream.*;


class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }
}

public class MergeLists{  

    public static void main(String[] args) {        
        Node nodeA = new Node(1);
        nodeA.next = new Node(2);
        nodeA.next.next = new Node(3);

        Node nodeB = new Node(5);
        nodeB.next = new Node(6);
        nodeB.next.next = new Node(7);

        Node nodeC = new Node(9);
        nodeC.next = new Node(10);
        nodeC.next.next = new Node(11);

        List<Node> nodes = new ArrayList<>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        Node mergedNode = mergeNodes(nodes);
        while(mergedNode != null){
            System.out.print(" "+mergedNode.val);
            mergedNode = mergedNode.next;
        }
    }

    public static Node mergeNodes(List<Node> nodes){        
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        for(Node currNode : nodes){
            minHeap.add(currNode);
        }        
        Node mergedNodeHead = null;
        Node mergedNodeTail = null;
        while(minHeap.size() > 0){
            Node currNode = minHeap.poll();
            if(mergedNodeHead == null){
                mergedNodeHead = new Node(currNode.val);
                mergedNodeTail = mergedNodeHead;
            }else{
                mergedNodeTail.next = new Node(currNode.val);
                mergedNodeTail = mergedNodeTail.next;
            }
            if(currNode.next != null){
                minHeap.add(currNode.next);
            }            
        }

        return mergedNodeHead;
    }

}

