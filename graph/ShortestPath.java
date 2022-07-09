package test.graph;

import java.util.*;

public class ShortestPath{
    public static Map<Integer, List<Integer>> createGraph(List<Integer[]> edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(Integer[] edge : edges){
            List<Integer> adjacentList = new ArrayList<>();            
            if(graph.containsKey(edge[0])){
                adjacentList =  graph.get(edge[0]);
            }
            adjacentList.add(edge[1]);
            graph.put(edge[0], adjacentList);

            adjacentList = new ArrayList<>(); 
            if(graph.containsKey(edge[1])){
                adjacentList =  graph.get(edge[1]);
            }
            adjacentList.add(edge[0]);
            graph.put(edge[1], adjacentList);
        }
        return graph;
    }

    public static int findShortestPathDFS(Map<Integer, List<Integer>> graph, int src, int dest){
        
        //Node
        Set<Integer> visited = new HashSet<>();
        //Node : Path
        ArrayDeque<Integer[]> stack = new ArrayDeque<>();
        stack.push(new Integer[]{src, 0});
        int shortestPath = Integer.MAX_VALUE;
        while(!stack.isEmpty()){            
            Integer[] currNode = stack.pop();
            System.out.println(Arrays.toString(currNode));
            if(graph.containsKey(currNode[0])){
                for(Integer neighbor : graph.get(currNode[0])){
                    int path = currNode[1] + 1;
                    if(neighbor == dest){
                        return Math.min(shortestPath, path);
                    }
                    if(!visited.contains(neighbor)){
                        stack.push(new Integer[]{neighbor, path});
                    }                 
                }
            }            
        }
        return 0;
    }

    public static int findShortestPathBFS(Map<Integer, List<Integer>> graph, int src, int dest){
        
        //Node
        Set<Integer> visited = new HashSet<>();
        //Node : Path
        ArrayDeque<Integer[]> queue = new ArrayDeque<>();
        queue.offer(new Integer[]{src, 0});
        int shortestPath = Integer.MAX_VALUE;
        while(!queue.isEmpty()){            
            Integer[] currNode = queue.poll();
            System.out.println(Arrays.toString(currNode));
            if(graph.containsKey(currNode[0])){
                for(Integer neighbor : graph.get(currNode[0])){
                    int path = currNode[1] + 1;
                    if(neighbor == dest){
                        return Math.min(shortestPath, path);
                    }
                    if(!visited.contains(neighbor)){
                        queue.offer(new Integer[]{neighbor, path});
                    }                 
                }
            }            
        }
        return 0;
    }
    public static void main(String[] args){
        List<Integer[]> edges = new ArrayList<>();
        edges.add(new Integer[]{0, 1});
        edges.add(new Integer[]{2, 0});
        edges.add(new Integer[]{2, 1});
        edges.add(new Integer[]{3, 2});     

        Map<Integer, List<Integer>> graph = createGraph(edges);
        System.out.println(graph);
        //System.out.println(findShortestPathDFS(graph, 0, 3));
        System.out.println(findShortestPathBFS(graph, 0, 3));
         
    }

}