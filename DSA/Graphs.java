package DSA;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class Graphs {


    ArrayList<Edge> adjList[];

    int vertices;

    public Graphs(int size){

        this.vertices = size;
        this.adjList = new ArrayList[size];

        for(int i = 0;i<size ; i++){
            adjList[i] = new ArrayList<Edge>();
        }

    }


    static  class  Edge{
        int src;
        int dest;

        int weight;

        public Edge(int src, int dest , int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public void addEdge(int index , Edge edge){

        this.adjList[index].add(edge);


    }




    public static void main(String[] args) {

        Graphs graph = new Graphs(4);
        graph.addEdge(0 , new Edge(0,2 , 2));

        graph.addEdge(1 , new Edge(1,2 , 10));
        graph.addEdge(1 , new Edge(1,3 , 0));

        graph.addEdge(2 , new Edge(2,0 ,2 ));
        graph.addEdge(2 , new Edge(2,1 , 10));
        graph.addEdge(2 , new Edge(2,3 , -1));

        graph.addEdge(3 , new Edge(3,1 , 0));
        graph.addEdge(3 , new Edge(3,2 , -1));

        graph.breadthFirstSearch(0);

        System.out.println("---------------------");




        Graphs graph2 = new Graphs(7);
        graph2.addEdge(0 , new Edge(0,1 , 2));
        graph2.addEdge(0 , new Edge(0,2 , 2));

        graph2.addEdge(1 , new Edge(1,0 , 10));
        graph2.addEdge(1 , new Edge(1,3 , 0));

        graph2.addEdge(2 , new Edge(2,0 ,2 ));
        graph2.addEdge(2 , new Edge(2,4, 10));


        graph2.addEdge(3 , new Edge(3,1 , 0));
        graph2.addEdge(3 , new Edge(3,4, -1));
        graph2.addEdge(3 , new Edge(3,5 , -1));

        graph2.addEdge(4 , new Edge(4,2 , -9));
        graph2.addEdge(4 , new Edge(4,3 , 13));
        graph2.addEdge(4 , new Edge(4,5, 12));

        graph2.addEdge(5 , new Edge(5,3, 17));
        graph2.addEdge(5 , new Edge(5,4, 1));
        graph2.addEdge(5 , new Edge(5,6, 6));

        graph2.addEdge(6, new Edge(6,5, 11));


        graph2.deathFirstSearch(new boolean[graph2.vertices] , 0);

        System.out.println("---------------finding all the paths from 0- 5 ------------");

        List<String> pathList = graph2.allPathsForTarget(new ArrayList<>() , new boolean[graph2.vertices] , 5 , 0 , new String(""));

        System.out.println(pathList);


        System.out.println("---------Detecting the cyclic in the graph-------");
        Graphs graphs =  new Graphs(5);
        graphs.addEdge(0 , new Edge(0, 2 , 8));
        graphs.addEdge(0, new Edge(0,3,6));
        graphs.addEdge(1, new Edge(1,0,8));
        graphs.addEdge(2, new Edge(2,3,5));
        graphs.addEdge(3, new Edge(3,4,10));
        graphs.addEdge(4,new Edge(4,0, -1));

        boolean[]vertices = new boolean[graphs.vertices];
        boolean iscyclic = false;
        for(int i = 0;i< graphs.vertices;i++){
            if(!vertices[i] ){
                iscyclic = graphs.isCyclicGraph(vertices , i ,new boolean[graphs.vertices]);
                if(iscyclic){
                    break;
                }

            }
        }
        System.out.println("Is Cyclic: "+ iscyclic);


        System.out.println("-----------Printing Graph vertices in topologicaal order");
        Graphs G = new Graphs(6);
        G.addEdge(2, new Edge(2,3,10));
        G.addEdge(3, new Edge(3,1,8));
        G.addEdge(5, new Edge(5,0,11));
        G.addEdge(5, new Edge(5,2,15));
        G.addEdge(4, new Edge(4,0,12));
        G.addEdge(4, new Edge(4,1,18));
        G.topSortUtil();


        System.out.println("-------Undirected Cyclic graph--------");
        Graphs g1 = new Graphs(3);
        g1.addEdge(0 , new Edge(0,1 , 10));
        g1.addEdge(0, new Edge(0,2, 12));
        g1.addEdge(1, new Edge(1, 0 , 13));
        g1.addEdge(1, new Edge(1, 2, 19));
        g1.addEdge(2, new Edge(2, 0 , 7));
        g1.addEdge(2, new Edge(2, 1, 11));
        boolean result = g1.isCyclicUnDirectedGraph(new boolean[g1.vertices] ,  0 , 0);
        System.out.println("Is graph cyclic "+ result);


        System.out.println("----------Finding shortest distances from src to all vertices---------");
        System.out.println("Using Dijkstra's Algo");

        Graphs g2 = new Graphs(6);

        g2.addEdge(0, new Edge(0,1 , 2));
        g2.addEdge(0, new Edge(0,1,4));
        g2.addEdge(1,new Edge(1,3,7));
        g2.addEdge(1,new Edge(1,2,1));
        g2.addEdge(2,new Edge(2,4,3));
        g2.addEdge(3,new Edge(3,5,1));
        g2.addEdge(4,new Edge(4,3,2));
        g2.addEdge(4,new Edge(4,5,5));


        System.out.println(Arrays.toString(g2.shortestDistancesDijkstras(0)));


        System.out.println("------Finding shortest path using Bellman algorithm------");
        Graphs g3 = new Graphs(5);

        g3.addEdge(0, new Edge(0,1 , 2));
        g3.addEdge(0, new Edge(0,1,4));

        g3.addEdge(1,new Edge(1,2,-4));
        g3.addEdge(2,new Edge(2,3,2));
        g3.addEdge(3,new Edge(3,4,4));
        g3.addEdge(4,new Edge(4,1,-1));

        System.out.println(Arrays.toString(g3.shortestBellmanfordAlgo(0)));


        System.out.println("-----Finding the cost of minimum spanning tree-------");
        Graphs g4 = new Graphs(4);

        g4.addEdge(0, new Edge(0,1 , 10));
        g4.addEdge(0, new Edge(0,2,15));

        g4.addEdge(0,new Edge(0,3,30));
        g4.addEdge(1,new Edge(1,0,10));
        g4.addEdge(1,new Edge(1,3,40));
        g4.addEdge(2,new Edge(2,0,15));
        g4.addEdge(2,new Edge(2,3,50));

        g4.addEdge(3,new Edge(3,0,30));
        g4.addEdge(3,new Edge(3,1,40));
        g4.addEdge(3,new Edge(3,2,50));


        System.out.println(g4.minSpanningTreePrimsAlgo());

        List<Edge> results = g4.minSpanningTreePrimsAlgoReturnsEdges();

        for(Edge e: results){
            System.out.println(e.src + " "+ e.dest +" "+e.weight);
        }

    }

    public void breadthFirstSearch(int s){

        boolean[]vertices = new boolean[this.vertices];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(this.adjList[s].get(0).src);
        vertices[s] = true;
        
        while(!queue.isEmpty()){

            int u = queue.poll();

            System.out.println(u);

            for(Edge e : this.adjList[u]){

                if(!vertices[e.dest]){
                    queue.add(e.dest);
                    vertices[e.dest] = true;
                }

            }

        }

    }

    public void deathFirstSearch(boolean[]vertices , int src){

        if(vertices[src] == true){
            return;
        }
        System.out.println(src);
        vertices[src] = true;
        for(Edge e : this.adjList[src]){

            int s = e.dest;

            if(!vertices[s]){

                deathFirstSearch(vertices,s);

            }

        }




    }



    public void deathFirstSearch2(boolean[]vertices , int src){

        if(vertices[src] == true){
            return;
        }

        vertices[src] = true;
        for(Edge e : this.adjList[src]){

            int s = e.dest;

            if(!vertices[s]){

                deathFirstSearch(vertices,s);

            }

        }
        System.out.println(src);

    }


    public List<String> allPathsForTarget(List<String>list , boolean[] vertices , int target , int src , String s){

        if(src == target){
            s = s +""+ src;
            list.add(s);
            return list;
        }

        vertices[src] = true;

        s = s+""+src;

        for(Edge e : this.adjList[src]){

            int u = e.dest;

            if(!vertices[u]){

                allPathsForTarget(list, vertices, target , u , s);

            }

        }

        vertices[src] = false;

        return list;
    }


    public boolean isCyclicGraph(boolean[]vertices , int current , boolean[]rec){

        vertices[current] = true;
        rec[current] = true;

        for(Edge e : this.adjList[current]){


            if(rec[e.dest] == true){
                return  true;
            }
            else if(!vertices[e.dest]){//once it is visited then we have already visited all its destinations so no need again
                if(isCyclicGraph(vertices,e.dest , rec)){
                    return  true;
                }
            }

        }
        rec[current] = false;
        return false;
    }

    public void topSortUtil(){
        boolean vertices[] = new boolean[this.vertices];
        Stack<Integer> stack = new Stack<>();
        for( int i = 0; i< this.vertices;i++){
            if(!vertices[i]){
                this.topoSort(vertices, i , stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+", ");
        }
        System.out.println();
    }

    public void topoSort(boolean[]vertices , int current , Stack<Integer>stack){

        vertices[current] = true;

        for(Edge e : this.adjList[current]){

            if(!vertices[e.dest]){
                topoSort(vertices, e.dest , stack);
            }

        }
        stack.push(current);

    }

    public boolean isCyclicUnDirectedGraph(boolean vertices[] , int current , int parent){

        vertices[current] = true;

        for(Edge e : this.adjList[current]){

            if(vertices[e.dest] && parent != e.dest){
                return  true;
            }
            else if(!vertices[e.dest]){
                if(isCyclicUnDirectedGraph(vertices , e.dest , current)){
                    return true;
                }
            }

        }

        return false;
    }

    public int[] shortestBellmanfordAlgo(int src){

        int [] distances = new int[this.vertices];
        for(int i = 0;i<this.vertices ;i++){
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;

        for(int i = 0;i<this.vertices ;i++){
            for(Edge e: this.adjList[i]){

                if(distances[e.src]!= Integer.MAX_VALUE && distances[e.src] + e.weight <distances[e.dest]){
                    distances[e.dest] = distances[e.src] + e.weight;
                }
            }
        }

        return  distances;
    }


    public int[] shortestDistancesDijkstras(int src){
        int[]distances = new int[this.vertices];

        for(int i = 0;i<this.vertices ;i++){
            distances[i] = Integer.MAX_VALUE;
        }
        distances[src] = 0;
        boolean[]visited = new boolean[this.vertices];
        PriorityQueue<Pair> pq = new PriorityQueue<>();


        pq.add(new Pair(src , 0));

        while(!pq.isEmpty()){

            int u = pq.peek().node;
            int v = pq.peek().dist;

            pq.poll();

            if(!visited[u]) {
                for (Edge e : this.adjList[u]) {
                    visited[u] = true;
                    if (!visited[e.dest]) {
                        if (v + e.weight < distances[e.dest]) {
                            distances[e.dest] = v + e.weight;
                            pq.add(new Pair(e.dest, distances[e.dest]));
                        }
                    }


                }
            }


        }



        return  distances;
    }


    public int minSpanningTreePrimsAlgo(){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));// we can src as 0,0;

        boolean []visited = new boolean[this.vertices];

        int cost = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            if(!visited[p.node]){
                visited[p.node] = true;
                cost += p.dist;
                for(Edge e: this.adjList[p.node]){
                    pq.add(new Pair(e.dest , e.weight));
                }

            }
        }


        return cost;
    }


    public List<Edge> minSpanningTreePrimsAlgoReturnsEdges(){

        List<Edge> result = new ArrayList<>();

        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(0,0,0));


        boolean []visited = new boolean[this.vertices];


        while(!pq.isEmpty()){

            Pair2 p = pq.poll();

            if(!visited[p.node]){

                visited[p.node] = true;

                result.add(new Edge(p.src , p.node, p.dist));
                for(Edge e: this.adjList[p.node]){
                    pq.add(new Pair2(e.src , e.dest , e.weight));
                }

            }



        }



        return result;
    }







     static  class  Pair implements  Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node , int dist){
            this.node = node;
            this.dist = dist;
        }

         @Override
         public int compareTo(Pair o) {
             return this.dist - o.dist;
         }
     }

    static  class  Pair2 implements  Comparable<Pair2> {

        int src;
        int node;
        int dist;

        public Pair2(int src,int node , int dist){
            this.src = src;
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair2 o) {
            return this.dist - o.dist;
        }
    }




}
