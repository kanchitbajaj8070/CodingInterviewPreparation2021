package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MapImplementationGraph{
    HashMap<Integer, List<Integer>> graph= new HashMap<>();
    MapImplementationGraph(int n)
    {
        for (int i = 0; i <n ; i++) {
            graph.put(i,new ArrayList<>());
        }
    }
    public void addEdge( int to, int from , boolean isDirected)
    {
        graph.get(to).add(from);
        if( !isDirected)
            graph.get(from).add(to);
    }
    public void viewGraph()
    {
        System.out.println(graph);
    }

    public void connectedComponents() {
HashSet<Integer> visited= new HashSet<>();
for( int i=0;i<graph.size();i++)
{
    if( !visited.contains(i))
    {
        connectedComponentsHelper(i,visited);
        System.out.println();
    }
}

    }

    private void connectedComponentsHelper(int i, HashSet<Integer> visited) {

        System.out.print(i+" , ");
        visited.add(i);
        for( int nbr:graph.get(i))
        {
            if( !visited.contains(nbr))
                connectedComponentsHelper(nbr,visited);
        }
    }
}
