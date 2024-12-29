package Graphs;

public class TopologicalSorting {
    public static void main(String[] args) {
        //refer graph3.png for the graph;
        GenericGraph<String> graph= new GenericGraph<>();
        graph.addVertex("python");
        graph.addVertex("datapreprocessing");
        graph.addVertex("mlbasics");
        graph.addVertex("pytorch");
        graph.addVertex("dl");
        graph.addVertex("dataset");
        graph.addVertex("faceai");
        graph.addEdge("python","pytorch",true);
        graph.addEdge("python","datapreprocessing",true);
        graph.addEdge("python","mlbasics",true);
        graph.addEdge("mlbasics","dl",true);
        graph.addEdge("pytorch","dl",true);
        graph.addEdge("dl","faceai",true);
        graph.addEdge("dataset","faceai",true);
//        graph.viewGraph();
        /* FOR DFS Topological Soring , it is important to remember we usee complete
        * bfs meaning there can be multiple connected componnets in graph and we
        * have to run dfs for each node by checking whether it is visited or not.
        * when we have explored dfs of all the neighbors , we add the element to front
        * of the answer list. (or reverse list after adding at end) */
//        graph.topologicalSorting();
        graph.BFSTopologicalSortingKahnAlgortihm();
        //for bfs , just remember that you have to use a queue ,
        //add indegree 0 nodes to queue.
        //remove from queue.
        //reduce indegree of nbr by 1.
        //if indegree ==0 , also add to queue.

    }
}
