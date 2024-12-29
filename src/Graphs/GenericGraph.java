package Graphs;

import java.util.*;

public class GenericGraph<T> {
    HashMap<T, List<T>> graph= new HashMap<>();

    public void addVertex(T v)
    {
        graph.put(v,new ArrayList<>());
    }
    public void addEdge(T to , T from , boolean isDirected)
    {
        graph.get(to).add(from);
        if( !isDirected)
            graph.get(from).add(to);
    }
    public void viewGraph()
    {
        System.out.println(graph);
    }
public void topologicalSorting()
{

    HashSet<T> visited= new HashSet<>();
    List<T> answer= new ArrayList<>();
    List<T> vertices= new ArrayList<>(graph.keySet());//could be skipped
    //could be skipped , just for checking something
    //System.out.println(vertices);
    for( T source:vertices) {
        if( !visited.contains(source))
        topologicalSorting(source, visited, answer);
    }
    Collections.reverse(answer);
    System.out.println(answer);
}

    private void topologicalSorting(T source, HashSet<T> visited, List<T> answer) {

        visited.add(source);
        for( T nbr:graph.get(source))
        {
            //explore as far as possible
            if( !visited.contains(nbr))
            {
                topologicalSorting(nbr,visited,answer);
            }
        }
        answer.add(source);
    }
    public void BFSTopologicalSortingKahnAlgortihm()
    {
        Map<T,Integer> indegree= new HashMap<>();
        for( T v:graph.keySet())
        {
            indegree.put(v,0);
        }
        for( T v:graph.keySet())
        {
            for( T nbr:graph.get(v))
            {
                indegree.put(nbr,indegree.get(nbr)+1);
            }
        }
        System.out.println(indegree);
        Queue<T> queue= new LinkedList<>();
        // add nodes with zzero indegree to queue.
        for( T v:indegree.keySet())
        {
            if( indegree.get(v)==0)
                queue.add(v);
        }
        //remove elements 1 by 1.
        //add neighbors if there indegree is zero
        while(!queue.isEmpty())
        {
            T node= queue.remove();
            System.out.println(node);
            for( T nbr:graph.get(node))
            {
                indegree.put(nbr,indegree.get(nbr)-1);
                if( indegree.get(nbr)==0)
                    queue.add(nbr);
            }
        }
//        System.out.println(indegree);
    }
    public boolean isCyclic()
    {
        HashSet<T> visited= new HashSet<>();
        HashMap<T,T> parent= new HashMap<>();
        for( T v:graph.keySet())
        {
            if(!visited.contains(v))
            {
                if( isCyclic(v,visited,parent))
                    return true;

            }
        }

        return false;
    }

    private boolean isCyclic(T v, HashSet<T> visited, HashMap<T,T> parent) {
        visited.add(v);
        for( T nbr:graph.get(v))
        {
            if( !visited.contains(nbr))
            {

                parent.put( nbr,v);
                if(isCyclic(nbr,visited,parent))
                    // very  imp step.
                    //dont't directly return , big mistake . return only if true ,
                    //other it doesnt't check for other nbrs.
                return true;
            }
            else
            {
                if(parent.get(v)!=null&& !(parent.get(v) == (nbr)))
                    return true;
            }
        }
    return false;
    }
    public boolean isCyclicForDirectedGraph()
    {
HashSet<T> visited= new HashSet<>();
HashSet<T> currentTree= new HashSet<>();
for( T v:graph.keySet())
{
    if( !visited.contains(v))
    {
        if( isCyclicForDirectedGraph(v,visited,currentTree))
            return true;
    }
}
return false;

    }

    private boolean isCyclicForDirectedGraph(T v, HashSet<T> visited, HashSet<T> currentTree) {

        visited.add(v);
        currentTree.add(v);
        for( T nbr:graph.get(v))
        {
            if( !visited.contains(nbr))
            {
                if(isCyclicForDirectedGraph(nbr,visited,currentTree)) // if imp step.
                    //dont't directly return , big mistake . return only if true ,
                    //other it doesnt't check for other nbrs.
                    return true;
            }
            else
            {
                if( currentTree.contains(nbr))
                {
                    return true;
                }
            }
        }

   currentTree.remove(v);
   return false;

    }
}



