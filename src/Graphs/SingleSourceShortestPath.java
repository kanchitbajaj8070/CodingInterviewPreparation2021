package Graphs;

public class SingleSourceShortestPath {
    public static void main(String[] args) {
        /*
        * Single source shortest path is implemented using BFS.
        * IT mean shortest path from a source to any other node ( destination)
        * in the graph.
        * IMP => In unweighted graph , distance calculated by BFS is the shortest.
        * Most Important Part in UNWEIGHTED ( note )
        * When the node is first discovered it is the shortest path.
        * Refer graph1.png for graph info*/
        AdjancencyListArrayRepresentaion graph= new AdjancencyListArrayRepresentaion(6);
        graph.addEdge(0,1,false);
        graph.addEdge(0,3,false);
        graph.addEdge(1,2,false);
        graph.addEdge(2,3,false);
        graph.addEdge(3,4,false);
        graph.addEdge(4,5,false);
        //graph.viewGraph();
        graph.singleSourceShortestPath(0);
        /*
        * SEE carefully the implemeentation .
        * Not used any visited hashset or counter .
        * Use Distance array and no counter for each level . Good optimization/interview question*/

    }
}
