package test.tree;
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {}
    Node(int val) { 
        this(val, null, null);
    }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;		
    }
}

public class ConnectTree{

    public static void main(String[] args){
        ConnectTree obj = new ConnectTree();

        int[] array = {1,2,3,4,5,6,7};
        Node root = obj.arrayToTree(array, 0);
        
        List<Integer> list = obj.preOrderTraversal(root);        
        System.out.println(list);
        
        root = obj.connect(root);
        //System.out.println(root.val);        
    }
    
    public Node connectOld(Node root) {
        Queue<Node> queue = new LinkedList<>();
        LinkedList<Node> resultNode = new LinkedList<>();
        queue.offer(root);        
        while(!queue.isEmpty()){            
            int size = queue.size();                              
            for(int i = 0 ; i < size ; i++){
                Node curr = queue.poll();                
                if(curr != null){
                    resultNode.add(curr);
                    queue.offer(curr.left);
                    queue.offer(curr.right); 
                }                              
            }
            resultNode.add(null);         
        }
        int i = 0;
        while(i < resultNode.size()-1){
            if(resultNode.get(i) != null){
                resultNode.get(i).next = resultNode.get(i+1);
            }
            i++;
        }
        System.out.println(resultNode);       
        return root;
    }

    public Node arrayToTree(int[] array, int i){        
        if(i >= array.length) return null;
        
        return new Node(array[i], arrayToTree(array, i * 2 + 1), arrayToTree(array, i * 2 + 2));
    }
    public List<Integer> preOrderTraversal(Node root){
        return preOrderTraversal(root, new ArrayList<>());
    }
    public List<Integer> preOrderTraversal(Node root, List<Integer> result){        
        if(root != null){
            result.add(root.val);
            preOrderTraversal(root.left, result);
            preOrderTraversal(root.right, result);
        }
        return result;
    }

}