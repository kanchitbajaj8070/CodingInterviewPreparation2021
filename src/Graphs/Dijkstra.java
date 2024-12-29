package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dijkstra {
    public static void main(String[] args) {
        WeightedGraphHashMap<Integer> graph= new WeightedGraphHashMap<>();
        //refer graph5.png
//        graph.addEdge(1,2,1,false);
//        graph.addEdge(1,3,4,false);
//        graph.addEdge(1,4,7,false);
//        graph.addEdge(2,3,1,false);
//        graph.addEdge(3,4,2,false);
//        graph.viewGraph();
//        graph.Dijkstra(1);

        //REFER GRAPH6QUES for the question ; GRAPh6 for answers
        graph.addEdge(0,1,4,false);
        graph.addEdge(0,7,8,false);
        graph.addEdge(1,2,8,false);
        graph.addEdge(1,7,11,false);
        graph.addEdge(2,8,2,false);
        graph.addEdge(7,8,7,false);
        graph.addEdge(7,6,1,false);
        graph.addEdge(8,6,6,false);
        graph.addEdge(2,5,4,false);
        graph.addEdge(2,3,7,false);
        graph.addEdge(6,5,2,false);
        graph.addEdge(3,5,14,false);
        graph.addEdge(3,4,9,false);
        graph.addEdge(5,4,10,false);
        graph.Dijkstra(0);
    }
}
