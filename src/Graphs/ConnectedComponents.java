package Graphs;

public class ConnectedComponents {
    public static void main(String[] args) {
        //refer graph2.png for details
        MapImplementationGraph graph= new MapImplementationGraph(8);
        graph.addEdge(0,1,false);
        graph.addEdge(0,3,false);
        graph.addEdge(0,4,false);
        graph.addEdge(2,1,false);
        graph.addEdge(2,3,false);
        graph.addEdge(5,6,false);
        graph.addEdge(6,7,false);
graph.connectedComponents();
    }
}
