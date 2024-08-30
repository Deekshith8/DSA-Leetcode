package DSA;

public class ArticulationPoint {

    public static void main(String[] args) {
        ArticulationPoint ap = new ArticulationPoint();

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
        graph.addEdge(4, new Graphs.Edge(4,3,0));

        ap.articulationPoint(graph);


    }



    public void articulationPoint(Graphs graph){

        boolean []visited = new boolean[graph.vertices];

        int[]dicoverytime = new int[graph.vertices];
        int[]lowtime = new int[graph.vertices];

        boolean[]Ap = new boolean[graph.vertices];

        int time = 0;
        for(int i =0 ;i< graph.vertices ; i++){
            if(!visited[i]){
                dfs(graph , visited, Ap , dicoverytime , lowtime , i , -1 , time);
            }
        }


        for(int i = 0 ; i< graph.vertices;i++){
            if(Ap[i]){
                System.out.println("Articulation point "+ i);
            }
        }

    }


    public void dfs(Graphs graph , boolean[]visited , boolean[]ap, int[]discoverytime ,
                    int[] lowtime , int current , int parent , int time){

        visited[current] = true;

        discoverytime[current] = lowtime[current] = ++time;
        int children = 0;

        for(Graphs.Edge e : graph.adjList[current]){

            if(e.dest == parent){

            } else if (visited[e.dest]){
                lowtime[current] = Math.min(discoverytime[e.dest] , lowtime[current]);
            } else if (!visited[e.dest]) {
                dfs(graph, visited, ap , discoverytime , lowtime , e.dest , current , time);

                if(discoverytime[current] <= lowtime[e.dest] && parent != -1){
                    ap[current] = true;
                }

                children++;
            }


        }

        if(parent == -1 && children > 1){
            ap[current] = true;
        }



    }






}
