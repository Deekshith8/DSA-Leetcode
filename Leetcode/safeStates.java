package Leetcode;

import java.util.*;

public class safeStates {

    public static void main(String[] args) {

        safeStates ss =new safeStates();
      int[][]graph =   {{1,2,3,4},{1,2},{3,4},{0,4},{}};

      //int[][]graph = {{1,2},{2,3},{5},{0},{5},{},{}};


        System.out.println(ss.eventualsafeStates(graph));
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> safestates = new ArrayList<>();

        boolean[]visited = new boolean[graph.length];

        boolean[]stack = new boolean[graph.length];





        for(int i = 0 ;i<graph.length ;i++){


                if(!visited[i]){
                    safeStates(graph , visited ,stack ,  i );
                }


        }

        for(int i =0 ;i<stack.length ;i++){
            if(!stack[i]){
                safestates.add(i);
            }
        }



        return safestates;
    }


    public boolean safeStates(int[][]graph , boolean visited[], boolean[]stack , int current){

        if(stack[current] ){
            return  false;
        }

        visited[current] = true;
        stack [current] =true;

        for(int i : graph[current]){


            if(!safeStates(graph, visited, stack, i)){

                return false;
            }

        }

        stack[current] = false;
       return true;

    }



    //using map makes it more time efficient
    public List<Integer> eventualsafeStates(int[][]graph){
        List<Integer> safestates = new ArrayList<>();

        Map<Integer , Boolean> map = new HashMap<>();

        boolean[]visited = new boolean[graph.length];

        for(int i = 0;i< graph.length ;i++){
            if(graph[i].length == 0){
                map.put(i , true);
            }
        }

        for(int i = 0;i<graph.length ;i++){

           if(!visited[i]){
               issafe(graph,i , visited , map);
           }

        }

        for(int i = 0;i<graph.length ;i++){
            if(map.containsKey(i)&&map.get(i)){
                safestates.add(i);
            }
        }


        return safestates;
    }



    public boolean issafe(int[][]graph , int current , boolean[]visited , Map<Integer, Boolean>map){

        if(map.containsKey(current)){
            return map.get(current);
        }


        if(visited[current]){
            return false;
        }
        visited[current] = true;


        for(int i : graph[current]){
            boolean b = issafe(graph , i , visited , map);

            if(!b){
                map.put(i , false);
                return  false;
            }
        }


        map.put(current , true);
        visited[current] = false;
        return true;
    }


}
