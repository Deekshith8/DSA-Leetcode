package DSA;

import java.util.Arrays;

public class BridgeDetectionOfGraph {

    public static void main(String[] args) {

        BridgeDetectionOfGraph bdg = new BridgeDetectionOfGraph();

        Graphs graph = new Graphs(5);

        graph.addEdge(0 , new Graphs.Edge(0,1,0));// no need of weight
        graph.addEdge(0 , new Graphs.Edge(0,2,0));
        graph.addEdge(0, new Graphs.Edge(0,3,0));

        graph.addEdge(1 , new Graphs.Edge(1,0,0));
        graph.addEdge(1, new Graphs.Edge(1,2,0));

        graph.addEdge(2, new Graphs.Edge(2,0,0));
        graph.addEdge(2, new Graphs.Edge(2,1,0));

        graph.addEdge(3, new Graphs.Edge(3,0,0));// no need of weight
        graph.addEdge(3 , new Graphs.Edge(3,4,0));
       // graph.addEdge(3 , new Graphs.Edge(3,5,0));


        graph.addEdge(4 , new Graphs.Edge(4,3,0));
       // graph.addEdge(4, new Graphs.Edge(4,5,0));

//        graph.addEdge(5, new Graphs.Edge(5,3,0));
//        graph.addEdge(5, new Graphs.Edge(5,4,0));

       bdg.bridgeEdge(graph);
    }


    public void bridgeEdge(Graphs graph){


        boolean[]visited = new boolean[graph.vertices];

        int[]discoveryt = new int[graph.vertices];

        int [] lowtime = new int[graph.vertices];

//       for(int i = 0;i<graph.vertices ;i++){
//           discoveryt[i] = Integer.MAX_VALUE;
//       }
//
//
//
//        for(int i = 0;i<graph.vertices ;i++){
//            lowtime[i] = Integer.MAX_VALUE;
//        }

        int time = 0;
        for(int i = 0 ;i < graph.vertices ;i++) {
            dfs(graph, i, -1, visited, discoveryt, lowtime, time);
        }



    }


    public void dfs(Graphs graph , int current, int parent , boolean [] visited , int[]discoverytime , int[] lowtime , int time){

        discoverytime[current] = lowtime[current] = ++time;

        visited[current] = true;

        for(Graphs.Edge e : graph.adjList[current]){

            if(e.dest == parent){

            } else if (!visited[e.dest]){

                dfs(graph , e.dest,current , visited, discoverytime , lowtime , time );
                lowtime[current] = Math.min(lowtime[e.dest] , lowtime [current]);

                if(discoverytime[current] < lowtime[e.dest]){
                    System.out.println(e.src +"--"+e.dest);
                }


            }
            else if (visited [ e.dest]){

                lowtime[current] = Math.min(discoverytime[e.dest] , lowtime[current]);

            }



        }




    }






}

