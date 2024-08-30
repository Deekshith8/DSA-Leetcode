package Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class countSubIslands {
    public static void main(String[] args) {



//       int[][] grid1 = new int[][]{{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
//        int [][]grid2 = new int[][]{{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1,0,1,1,0}, {0, 1, 0, 1, 0}};


        int[][] grid1 = new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}};
       int [][]grid2 = new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};


        countSubIslands CSI = new countSubIslands();
        System.out.println(CSI.countSubIslands(grid1,grid2));

    }



    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int m = grid2.length;
        int n = grid2[0].length;
        int subIslands = 0;
        boolean[][] isVisited = new boolean[grid2.length][grid1[0].length];


        for(int i = 0 ;i< grid2.length ; i++){
            for(int j = 0;j< grid2[i].length;j++){

                if(grid2[i][j] == 1 && !isVisited[i][j] ){
                       isVisited[i][j] = true;
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.add(new int[]{i,j});
                        boolean isNotCommonIsland = false;
                        while(!queue.isEmpty()){

                            int[]indeces = queue.poll();
                            int tempi = indeces[0];
                            int tempj = indeces[1];

                            if(grid1[tempi][tempj] != 1){
                             isNotCommonIsland = true;
                             continue;
                            }

                            //up
                            tempi = indeces[0]-1;
                             tempj = indeces[1];
                            while(tempi >= 0 && !isVisited[tempi][tempj] && grid2[tempi][tempj] == 1){
                                queue.add(new int[]{tempi,tempj});
                                isVisited[tempi][tempj] = true;
                                tempi--;
                            }

                            //down
                            tempi = indeces[0]+1;
                            tempj = indeces[1];

                            while(tempi < m && !isVisited[tempi][tempj] && grid2[tempi][tempj]==1){
                                queue.add(new int[]{tempi,tempj});
                                isVisited[tempi][tempj] = true;
                                tempi++;
                            }

                            // right
                            tempi = indeces[0];
                            tempj = indeces[1]+1;

                            while(tempj < n && !isVisited[tempi][tempj] && grid2[tempi][tempj]==1){
                                queue.add(new int[]{tempi,tempj});
                                isVisited[tempi][tempj] = true;
                                tempj++;
                            }


                            //left
                            tempi = indeces[0];
                            tempj = indeces[1]-1;

                            while(tempj >= 0 && !isVisited[tempi][tempj] && grid2[tempi][tempj]==1){
                                queue.add(new int[]{tempi,tempj});
                                isVisited[tempi][tempj] = true;
                                tempj++;
                            }

                        }
                        if(!isNotCommonIsland){
                            subIslands++;
                        }

                }
            }
        }





     return subIslands;
    }




}
