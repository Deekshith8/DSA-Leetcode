package DSA;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class cheapestFlightsInKstops {


    class Pair implements Comparable<Pair> {

        int dest;

        int cost;

        int noOfStops;

        public Pair( int dest, int cost, int noOfStops) {

            this.dest = dest;
            this.cost = cost;
            this.noOfStops = noOfStops;
        }


        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) {
//
//      int   n = 4;
//      int[][]flights = {{0,1,100},{1,2,100},{0,2,100},{1,3,600},{2,3,200}};
//      int src = 0, dst = 3, k = 1;


//        int n = 10;
//        int src = 6;
//        int dst =0;
//        int[][] flights = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}};
//        int k =7;


//        int n = 3;
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
//        int src = 0, dst = 2, k = 0;


//       int  n = 3;
//       int[][] flights = {{0,1,2},{1,2,1},{2,0,10}};
   //     int src = 1 ;int dst = 2 ; int k = 1;

//      int  n =  5;
//      int[][] flights =  {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
//      int   src = 2;
//       int  dst = 1;
//              int k = 1;

       int n=  4;
        int[][]  flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
       int  src = 0;
       int dst = 3;
        int k = 1;


        cheapestFlightsInKstops cfs = new cheapestFlightsInKstops();

        System.out.println(cfs.findCheapestPrice(n, flights, src, dst, k));


    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        List<Pair>[] adjList = new ArrayList[n];

         int[] stops  = new int[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            stops[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < flights.length; i++) {

            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];
            adjList[s].add(new Pair(d, c, 0));
        }


        int cost = Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src, 0, 0));

//        int steps = 0;

        while (!pq.isEmpty()) {


            Pair p = pq.poll();


            if(p.noOfStops > stops[p.dest]){
                continue;
            }
            stops[p.dest] = p.noOfStops;
                if (p.noOfStops > k + 1) {
                    continue;
                }


                if (p.noOfStops == k + 1 && p.dest == dst) {
                    return p.cost;
                } else if (p.dest == dst) {

                    cost = Math.min(cost, p.cost);
                }



                for (Pair temp : adjList[p.dest]) {
                    pq.add(new Pair(temp.dest, p.cost + temp.cost, p.noOfStops + 1));
                }

            }



            return cost == Integer.MAX_VALUE ? -1 : cost;
        }





}

