package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class courseSchedule {

    public static void main(String[] args) {

        int numofcourses = 3;
        int[][] prerequisited = {{1,0} ,{1,2},{0,2}};

        courseSchedule cs = new courseSchedule();
        System.out.println(cs.canFinish(numofcourses , prerequisited));

    }


    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<Integer>[] adjList = createGraph(numCourses , prerequisites);

        boolean[] visited = new boolean[numCourses];


        for(int i = 0; i<numCourses ;i++){
            if( !visited[i]){
              if(isCyclic(visited , i , adjList)){
                  return false;
              }
            }
        }

        return true;
    }

    public boolean isCyclic(boolean[]visited ,  int current , List<Integer>[]adjList){
        if(visited[current] == true){
            return true;
        }


        visited[current] = true;
        for(int i:adjList[current] ){


               if(isCyclic(visited, i , adjList)){
                   return true;
               }

        }
        visited[current] = false;
        return false;
    }


    List<Integer>[] createGraph(int numofcourses ,  int[][]prereqs){

        List<Integer>[] adjList = new ArrayList[numofcourses];

        for(int i = 0;i<numofcourses ; i++){
            adjList[i] = new ArrayList<Integer>();
        }

        for(int[] arr : prereqs){
            adjList[arr[0]].add(arr[1]);
        }
       return  adjList;
    }

}
