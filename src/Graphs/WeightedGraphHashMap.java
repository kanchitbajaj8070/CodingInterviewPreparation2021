package Graphs;

import java.util.*;

public class WeightedGraphHashMap <T>{
   /*
    A=> (B,20),(D,50),(C,10)
    B=>(D,30),(A,20)
    C=>(A,10),(D,40)
    */
   public class Pair implements Comparable<Pair>
   {
       Integer weight;
       T vertex;
       Pair( T v, Integer w)
       {
           vertex=v;
           weight=w;
       }
       @Override
       public String toString()
       {
           return "( "+ vertex +" , "+ weight+" )";
       }

       @Override
       public int compareTo(Pair o) {
           return this.weight-o.weight;
       }


   }
   HashMap<T, List<Pair>> graph= new HashMap<>();
    public void addEdge( T to, T from , int weight,boolean isDirected)
    {
        if( !graph.containsKey(to))
        graph.put(to,new ArrayList<>());
        if( !graph.containsKey(from))
            graph.put(from,new ArrayList<>());
        graph.get(to).add(new Pair( from, weight));
        if( !isDirected)
            graph.get(from).add(new Pair( to, weight));

    }
    public void viewGraph()
    {
        System.out.println(graph);
    }

public void Dijkstra( T source)
{
   HashMap<T,Integer> distance= new HashMap<>();
    HashMap<T,Boolean> isFinalized= new HashMap<>();//MOST IMPORTANT TO REMEBER
   for( T v:graph.keySet())
       distance.put(v,Integer.MAX_VALUE);
    for( T v:graph.keySet())
        isFinalized.put(v,false);
   distance.put(source,0);
   isFinalized.put(source,true);
    TreeSet<Pair> queue= new TreeSet<>();
    queue.add(new Pair(source,0));
    while (!queue.isEmpty())
    {
        System.out.println(queue);
        Pair node= queue.pollFirst();
        // WHY IS IT finalised?
        //because all node present after it already have a longer path, so there cannot be a
        //shorter path , so we finalize the distance.
        isFinalized.put(node.vertex,true);//most important step
        for( Pair nbr:graph.get(node.vertex))
        {
            if( distance.get(nbr.vertex).equals(Integer.MAX_VALUE))
            {
                distance.put(nbr.vertex,nbr.weight+distance.get(node.vertex));
                queue.add(new Pair(nbr.vertex,distance.get(nbr.vertex)));
            }
            else
            {

    if( !isFinalized.get(nbr.vertex)&& distance.get(nbr.vertex)>distance.get(node.vertex)+
    nbr.weight)
    {
        queue.remove(new Pair(nbr.vertex,distance.get(nbr.vertex)));
        distance.put(nbr.vertex,nbr.weight+distance.get(node.vertex));
        queue.add(new Pair(nbr.vertex,distance.get(nbr.vertex)));
        /* To simulate updation we have performed this delete and insert operations*/
    } }

        }


    }
    System.out.println(queue);
    System.out.println(" ============ANSWER=========");
    System.out.println(distance);

}
}
