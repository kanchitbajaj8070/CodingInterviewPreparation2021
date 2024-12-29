package Graphs;

public class DirecteGraphCycleDetection {
    public static void main(String[] args) {
        //refer graph4.png for graph details
        GenericGraph<Integer> graph= new GenericGraph<>();

        for (int i = 0; i <7 ; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(0,1,true);
        graph.addEdge(1,2,true);
        graph.addEdge(2,3,true);
        graph.addEdge(3,4,true);
        graph.addEdge(4,5,true);
        graph.addEdge(1,5,true);
        graph.addEdge(5,6,true);
        //graph.addEdge(4,2,true);
        graph.viewGraph();
        System.out.println(graph.isCyclicForDirectedGraph());
        /* Remeber - in code return true only if the result for nbr is true.
        * dont't directly return , because if for first nebr answer is false,
        * it won't check for other neighbours*/

    }
}
