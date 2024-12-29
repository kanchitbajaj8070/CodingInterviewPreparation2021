package Graphs;

public class CycleDetectionUndirectedGraph {
    public static void main(String[] args) {
        // if there is only one connected component in a graph
        //and there are no cycle , then it is a tree(important )!!
       GenericGraph<Integer> graph= new GenericGraph<>();
       for( int i=0;i<4;i++)
           graph.addVertex(i);
       graph.addEdge(0,1,false);
       graph.addEdge(0,2,false);
       graph.addEdge(1,3,false);
       graph.addEdge(2,3,false);
       graph.viewGraph();
       //for cyclic in undirected graph , we have to check whether there are more
        //than one path to reach a node or not
        System.out.println(graph.isCyclic());
        /* simplying checking visited wont work , we have to keep a parent map
        * to see where we came from*/
        // checking a graph for a tree can be done in same way an also checking
        //for only one connected component



    }
}
