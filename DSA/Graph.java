package DSA;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graph {

   private  int[][]adjmatrix;
   private  int vertices;
   private int edges;

    public Graph(int nodes){
        this.vertices = nodes;
        this.edges = 0;
        this.adjmatrix = new int[nodes][nodes];
    }

    public void addEdge(int index1 , int index2){

        this.adjmatrix[index1][index2] = 1;
        this.adjmatrix[index2][index1] = 1;
        this.edges++;
    }

    public void removeEdge(int index1 , int index2){

        this.adjmatrix[index1][index2] = 0;
        this.adjmatrix[index2][index1] = 0;
        this.edges--;
    }


    public static void main(String[] args) {

        Graph graph = new Graph(4);
        //adding the edge between two nodes;
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,0);

        for(int i=0;i<4 ;i++){
        System.out.println(Arrays.toString(graph.adjmatrix[i]));
        }


        System.out.println("---------Removing the edge--------");

        //removing one edge
        graph.removeEdge(0,3);
        for(int i=0;i<4 ;i++){
            System.out.println(Arrays.toString(graph.adjmatrix[i]));
        }

        graph.addEdge(3,0);//adding back the edge

        System.out.println("-------Removing Node-------");


    }




}
