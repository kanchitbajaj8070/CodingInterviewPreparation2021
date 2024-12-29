package Graphs;

import java.util.*;

public class AdjancencyListArrayRepresentaion {
    List<List<Integer>> edges;
    AdjancencyListArrayRepresentaion(int n)
    {
        edges=new ArrayList<>(n);
        for( int i=0;i<n;i++)
            edges.add(new ArrayList<>());
    }
    public void addEdge( int to , int from,boolean isDirected)
    {
        edges.get(to).add(from);
        if( !isDirected)
            edges.get(from).add(to);
    }
    public void viewGraph()
    {
        for(int i=0;i<edges.size();i++)
        {
            System.out.println("Vertex "+i+" , "+" edges : "+edges.get(i).toString());
        }
    }
    public List<Integer> getEdges(int vertex)
    {
        return edges.get(vertex);
    }
    public void BFS(int start)
    {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(start);
        HashSet<Integer> visited= new HashSet<>();
        visited.add(start);
        while( !queue.isEmpty())
        {
            int node=queue.peek();
            System.out.print(node+" , ");
            queue.remove();
            for( int i : getEdges(node))
            {
                if( !visited.contains(i))
                {
                    visited.add(i);
                    queue.add(i);
                }
            }
        }

    }
    public int singleSourceShortestPath(int source,int destination)
    {
        Queue<Integer> queue= new LinkedList<>();
        HashMap<Integer,Integer> parent= new HashMap<>();
        int[] distance=new int[edges.size()];//distance of all vertoces from source.
        Arrays.fill(distance,Integer.MAX_VALUE);//at start distance is infinity.
        distance[source]=0;
        queue.add( source);
        parent.put(source,source);
        while(!queue.isEmpty())
        {
            int node= queue.peek();
            queue.remove();
            for( int nbr:getEdges(node))
            {
                if( distance[nbr]==Integer.MAX_VALUE)//discovered for first tym
                {
                    parent.put(nbr,node);
                    distance[nbr]=distance[node]+1;
                    queue.add(nbr);
                }
            }
        }
        System.out.println(" PATH FROM "+ source+" TO "+ destination +" is :");
        int start=destination;
        while(start!=source)
        {
            System.out.print(start+" -> ");
            int p=parent.get(start);
            start=p;
        }
        System.out.println(source);
        return distance[destination];

    }
    public void singleSourceShortestPath(int source)
    {
        Queue<Integer> queue= new LinkedList<>();
        int[] distance=new int[edges.size()];//distance of all vertoces from source.
        Arrays.fill(distance,Integer.MAX_VALUE);//at start distance is infinity.
        distance[source]=0;
        queue.add( source);
        while(!queue.isEmpty())
        {
            int node= queue.peek();
            queue.remove();
            for( int nbr:getEdges(node))
            {
                if( distance[nbr]==Integer.MAX_VALUE)//discovered for first tym
                {
                    distance[nbr]=distance[node]+1;
                    queue.add(nbr);
                }
            }
        }
        for(int i=0;i<edges.size();i++)
            System.out.println("Node " +i+ " is at dist "+distance[i]+ " from source" );

    }
    public void dfs( int source)
    {
        HashSet<Integer> visited= new HashSet<>();
        dfs( source,visited);
    }

    private void dfs(int source, HashSet<Integer> visited) {
        System.out.print(source+" , ");
        visited.add(source);
        for (int i : getEdges(source)) {
            if( !visited.contains(i))
                dfs(i,visited);
        }
    }



   /*     0 => {1,2}
        1 =>{2,0}
2={3,0,1}
3={2}*/
    }

