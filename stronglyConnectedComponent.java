package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.RunnableScheduledFuture;

public class stronglyConnectedComponent {

    public static void main(String[] args) {
        Graphs g = new Graphs(5);
        g.addEdge(0, new Graphs.Edge(0,2,0));
        g.addEdge(0, new Graphs.Edge(0,3,0));

        g.addEdge(1, new Graphs.Edge(1,0,0));
        g.addEdge(2, new Graphs.Edge(2,1,0));
        g.addEdge(3, new Graphs.Edge(3,4,0));

        stronglyConnectedComponent sc = new stronglyConnectedComponent();
        sc.scc(g);

    }

    public void scc(Graphs graph){

        Stack<Integer> stack = new Stack<>();

        boolean[]visited = new boolean[graph.vertices];


        //step 1
        //taking vertices in top sort;
       for(int i = 0;i< graph.vertices ;i++){
           if(!visited[i]){

               graph.topoSort(visited , i , stack);
           }
       }



       //step2
       Graphs cloneGraph = new Graphs(graph.vertices);

        for(int i = 0 ; i<graph.vertices ;i++){
            visited[i] = false;
            for(Graphs.Edge e : graph.adjList[i]){

                cloneGraph.addEdge(e.dest , new Graphs.Edge(e.dest , e.src , 0));//weight no need

            }
        }


        //step 3
        List<List<Integer> >  results = new ArrayList<>();
        while(!stack.isEmpty()){
            int s = stack.pop();

            if(!visited[s] ){
                results.add(new ArrayList<>());
                dfs(cloneGraph , visited ,s, results);
            }


        }


        System.out.println(results);

    }


    public void  dfs (Graphs graph , boolean [] visited ,int current, List<List<Integer>>results){

        visited[current] = true;

        results.get(results.size()-1).add(current);

        for(Graphs.Edge e : graph.adjList[current]){
            if(!visited[e.dest]){
                dfs(graph , visited , e.dest , results);
            }
        }





    }




}
