package Leetcode;

import java.util.*;
import java.util.Queue;

public class rottenOranges {

    public static void main(String[] args) {


        int[][] arr = {{2,1,2},
                      {1,1,1},
                      {0,1,1},
                      {0,0,1}};
        rottenOranges rotten = new rottenOranges();
        System.out.println(rotten.minTimePossible(arr));

    }


    public int minTimePossible(int[][]grid){

        int fresh = 0;//for refernce useful at the end

        int min = 0;



        Queue<int[]> queue = new ArrayDeque<>();




        for(int i = 0 ; i< grid.length ;i++){

            for(int j = 0 ; j< grid[i].length ;j++){


                if(grid[i][j] == 2){

                    queue.add(new int[]{i,j});

                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        System.out.println(fresh);
        System.out.println(queue);
        System.out.println(grid.length);
        List<int[]> list = new ArrayList<>();

        while(!queue.isEmpty()){

            int x = queue.peek()[0];
            int y = queue.peek()[1];


            queue.poll();

            if(x+1 < grid.length && grid[x+1][y] == 1){
                list.add(new int[]{x+1, y });
                grid[x+1][y] = 2;
                fresh -- ;
            }
             if(x-1 >=0 && grid[x-1][y] == 1  ){
                list.add(new int[]{x-1, y });
                 grid[x-1][y] = 2;
                fresh --;

            }
             if(y+1 < grid[x].length && grid[x][y+1] == 1 ){
                list.add(new int[]{x, y+1});
                 grid[x][y+1] = 2;
                fresh--;
            }
             if(y-1 >= 0 && grid[x][y-1] == 1 ){
                list.add(new int[]{x, y-1});
                 grid[x][y-1] = 2;
                fresh--;
            }

            if(queue.isEmpty() && !list.isEmpty()){
                min++;
               queue.addAll(list);
               list.removeAll(list);
            }



        }

        System.out.println(fresh);




        return fresh == 0 ? min : -1 ;


    }


}
