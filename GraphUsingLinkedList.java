package DSA;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphUsingLinkedList {

    private LinkedList<Integer>[] adjMatrix;

    public GraphUsingLinkedList(int nodes){

        this.adjMatrix = new LinkedList[nodes];

        for(int i = 0 ;i<nodes ; i++){
            this.adjMatrix[i] = new LinkedList<>();
        }

    }

    public void addEdge(int index1 , int index2){

        this.adjMatrix[index1].add(index2);
        this.adjMatrix[index2].add(index1);


    }

    public void breadthFirstSearch(int s){

        boolean[]vertices = new boolean[this.adjMatrix.length];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(s);
        vertices[s] = true;
        while(!queue.isEmpty()){

            int u = queue.poll();

            System.out.println(u);

            for(int n : this.adjMatrix[u]){
                if(! vertices[n]){
                    vertices[n] = true;
                    queue.add(n);
                }
            }

        }




    }


    public static void main(String[] args) {

        GraphUsingLinkedList graphUsingLinkedList = new GraphUsingLinkedList(5);

        graphUsingLinkedList.addEdge(0,1);
        graphUsingLinkedList.addEdge(1,2);
        graphUsingLinkedList.addEdge(2,3);
        graphUsingLinkedList.addEdge(3,0);
        graphUsingLinkedList.addEdge(2,4);

        for(int i= 0 ;i<graphUsingLinkedList.adjMatrix.length ;i++) {
            System.out.println(i+" "+graphUsingLinkedList.adjMatrix[i]);
        }

        System.out.println("------visiting all the vertices-------");
        graphUsingLinkedList.breadthFirstSearch(0);



    }


}
