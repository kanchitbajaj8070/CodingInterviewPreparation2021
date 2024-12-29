package Graphs;

public class DFS {
    public static void main(String[] args) {
        //refer to graphs1 image for the graph
        AdjancencyListArrayRepresentaion graph= new AdjancencyListArrayRepresentaion(6);
        graph.addEdge(0,1,false);
        graph.addEdge(0,3,false);
        graph.addEdge(1,2,false);
        graph.addEdge(2,3,false);
        graph.addEdge(3,4,false);
        graph.addEdge(4,5,false);
        //graph.viewGraph();
        graph.dfs(0);
    }
}
