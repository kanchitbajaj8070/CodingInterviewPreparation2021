package Graphs;

public class SnakesAndLadders {
    public static void main(String[] args) {

        // starting at 0 , wants to reach a destination.
        //min number of dice throws required and the path required has to found.
        //refer board.png for actual board desctiption.
        //each values in the array indicates whether to move forward ot backward on
        //coming at this position.
        int[] board= new int[37];
//LADDERS
        board[2]=13;
        board[5]=2;
        board[9]=18;
        board[18]=11;
        board[25]=10;
    //SNAKES
        board[17]= -13;
        board[20]= -14;
        board[24]= -18;
        board[32]=-2;
        board[34]=-22;
        AdjancencyListArrayRepresentaion graph = new AdjancencyListArrayRepresentaion(board.length);
        for (int i = 0; i <=36 ; i++) {
//edges are directed;
            for( int j=1;j<=6;j++) {
                if(i+j<=36&&i+j+board[i+j]<=36) // important note
                graph.addEdge(i, i + j + board[i + j], true);
            }
        }
       // graph.viewGraph();
        System.out.println(graph.singleSourceShortestPath(0,36));

    }
}
